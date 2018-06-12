package application.view;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import application.Main;
import application.entity.Subjects;
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

public class MainWindowController {
	@FXML
	private Button logoutButton;
	@FXML
	private TextField titleTextBox;
	@FXML
	private ComboBox<Subjects> SubjectComboBox;
	@FXML
	private TextField maxPunctationTextBox;
	@FXML
	private ComboBox examComboBox;
	@FXML
	private ComboBox studentComboBox;
	@FXML
	private TextField resultPunctationTextBox;
	@FXML
	private Button addExamButton;
	@FXML
	private Button saveButton;
	@FXML
	private TextField degreeTextBox;

	private Main mainApp;
	private String profesorID;
	private String studentID;
	private String examID;

	private SubjectService subjectService = new SubjectService();


	@FXML
	public void logoutButtonAction(ActionEvent event) {
		Stage stage = (Stage) logoutButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void addExamButtonAction(ActionEvent event) {
		Statement s1;
		try {
			s1 = Main.getStatement();
			if (Main.showQuestionDialog("Potwierdzenie", "Czy napewno chcesz doda� egzamin?", "")) {
				String sqlInsert = "INSERT INTO Exams(ExamName, SubjectID, MaxPunctation) VALUES('"
						+ titleTextBox.getText() + "', '" + SubjectComboBox.getValue().getSubjectID() + "', "
						+ Integer.parseInt(maxPunctationTextBox.getText()) + ")";

				s1.executeUpdate(sqlInsert);
				Main.showInformation("Dodawanie egzaminu", "Egzamin zosta� dodany.", AlertType.INFORMATION);
			}
		} catch (ClassNotFoundException | SQLException e) {
			Main.showInformation("Dodawanie egzaminu", "Dodawanie egzaminu nie powiod�o si�.", AlertType.ERROR);
			e.printStackTrace();
		}
	}

	@FXML
	public void saveButtonAction(ActionEvent event) {
		Statement s1;
		try {
			s1 = Main.getStatement();
			if (Main.showQuestionDialog("Zapisywanie", "Czy napewno chcesz zapisa� zmiany i wyliczy� ocen�?", "")) {
				String sqlInsert = "INSERT INTO StudentDegrees(ExamID, ProfesorID, StudentID, Degree, ResultPunctation) VALUES("
						+ examID + ", " + Integer.parseInt(profesorID) + ", " + studentID + ", "
						+ getDegreeByResult(Integer.parseInt(resultPunctationTextBox.getText())) + ", "
						+ Integer.parseInt(resultPunctationTextBox.getText()) + ");";
				s1.executeUpdate(sqlInsert);
				Main.showInformation("Zapisywanie", "Zapisano ocen�.", AlertType.INFORMATION);
			}
		} catch (ClassNotFoundException | SQLException e) {
			Main.showInformation("Zapisywanie", "Zapisywanie zmian nie powiod�o si�.", AlertType.ERROR);
			e.printStackTrace();
		}
	}

	private String getDegreeByResult(int parseInt) {

		return null;
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
			mainApp.getStage().setTitle("Okno g��wne");
			mainApp.getStage().show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init(Main mainApp) {
		this.setMainApp(mainApp);
		try {
			this.SubjectComboBox.setItems(FXCollections.observableArrayList(subjectService.getAllSubjects()));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
}
