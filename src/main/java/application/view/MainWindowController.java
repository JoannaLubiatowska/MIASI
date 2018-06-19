package application.view;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import application.Main;
import application.entity.Exams;
import application.entity.StudentDegrees;
import application.entity.Students;
import application.entity.Subjects;
import application.service.ExamService;
import application.service.LoginService;
import application.service.StudentDegreeService;
import application.service.StudentService;
import application.service.SubjectService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainWindowController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -575996413308360419L;
	@FXML
	private transient Button logoutButton;
	@FXML
	private transient TextField titleTextBox;
	@FXML
	private transient ComboBox<Subjects> SubjectComboBox;
	@FXML
	private transient TextField maxPunctationTextBox;
	@FXML
	private transient ComboBox<Exams> examComboBox;
	@FXML
	private transient ComboBox<Students> studentComboBox;
	@FXML
	private transient TextField resultPunctationTextBox;
	@FXML
	private transient Button addExamButton;
	@FXML
	private transient Button saveButton;
	@FXML
	private transient TextField degreeTextBox;

	private transient SubjectService subjectService = new SubjectService();
	private transient ExamService examService = new ExamService();
	private transient StudentService studentService = new StudentService();
	private transient StudentDegreeService studentDegreeService = new StudentDegreeService();


	@FXML
	public void logoutButtonAction(ActionEvent event) {
		Stage stage = (Stage) logoutButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void addExamButtonAction(ActionEvent event) {
		Exams exam = new Exams(null, titleTextBox.getText(), SubjectComboBox.getValue().getSubjectID(), Integer.parseInt(maxPunctationTextBox.getText()));
		
		if (Main.showQuestionDialog("Potwierdzenie", "Czy napewno chcesz dodaæ egzamin?", "")) {
			try {
				if (examService.saveNewExam(exam)) {
					Main.showInformation("Dodawanie egzaminu", "Egzamin zosta³ dodany.", AlertType.INFORMATION);
				} else {
					Main.showInformation("Dodawanie egzaminu", "Dodawanie egzaminu nie powiod³o siê.", AlertType.ERROR);
				}
			} catch (ClassNotFoundException | SQLException e) {
				Main.showInformation("Dodawanie egzaminu", "Dodawanie egzaminu nie powiod³o siê.", AlertType.ERROR);
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void saveButtonAction(ActionEvent event) {
		StudentDegrees degree = new StudentDegrees(null, examComboBox.getValue().getExamID(), LoginService.instance().getCurrentUser().getProfesorID(), studentComboBox.getValue().getStudentID(), Integer.valueOf(resultPunctationTextBox.getText()), null);
		
		if (Main.showQuestionDialog("Zapisywanie", "Czy napewno chcesz zapisaæ zmiany i wyliczyæ ocenê?", "")) {
			Map<String, Object> variableMap = new HashMap<String, Object>();
			variableMap.put("studentDegree", degree);
			variableMap.put("showDegreeCommand", new ShowDegreeDelegate());
			variableMap.put("saveStudentDegreeCommand", studentDegreeService.saveStudentDegreeDelegate);
			Main.processEngine.getRuntimeService().startProcessInstanceByKey("process_pool2", variableMap);
		}
	}

	public static void showMainWindow(Main mainApp) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MainWindow.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			MainWindowController controller = (MainWindowController) loader.getController();
			controller.init(mainApp);
			mainApp.getStage().setScene(scene);
			mainApp.getStage().setTitle("Okno g³ówne");
			mainApp.getStage().show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init(Main mainApp) {
		this.setMainApp(mainApp);
		try {
			this.SubjectComboBox.setItems(FXCollections.observableArrayList(subjectService.getAllSubjects()));
			this.examComboBox.setItems(FXCollections.observableArrayList(examService.getAllExams()));
			this.studentComboBox.setItems(FXCollections.observableArrayList(studentService.getAllStudents()));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void setMainApp(Main mainApp) {
	}
	

	public class ShowDegreeDelegate implements JavaDelegate, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -3775361008248553319L;

		@Override
		public void execute(DelegateExecution execution) throws Exception {
			String degreeLabel = execution.getVariable("degreeLabel").toString();
			degreeTextBox.setText(degreeLabel);
		}

	}
}
