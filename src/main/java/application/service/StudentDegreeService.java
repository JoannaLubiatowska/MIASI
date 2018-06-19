package application.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import application.Main;
import application.entity.StudentDegrees;
import javafx.scene.control.Alert.AlertType;

public class StudentDegreeService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2450439927346796070L;
	public final SaveStudentDegreeDelegate saveStudentDegreeDelegate = new SaveStudentDegreeDelegate();
	
	public boolean saveNewDegree(StudentDegrees degree) throws ClassNotFoundException, SQLException {
		String insert = String.format("INSERT INTO StudentDegrees(ExamID, ProfesorID, StudentID, Degree, ResultPunctation) VALUES(%d, %d, %d, %d, %d)",
				degree.getExamID(), degree.getProfesorID(), degree.getStudentID(), /*resultPunctator.getDegree(examService.getExamById(degree.getExamID()), degree.getResultPunctation())*/5, degree.getResultPunctation());
		int result = 0;

		try (Statement statement = Main.getStatement()) {
			result = statement.executeUpdate(insert);
		}
		
		return result == 1;
	}
	
	public class SaveStudentDegreeDelegate implements JavaDelegate, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8430574589243612462L;

		@Override
		public void execute(DelegateExecution execution) throws Exception {
			StudentDegrees studentDegree = (StudentDegrees) execution.getVariable("studentDegree");
			try {
				if (saveNewDegree(studentDegree)) {
					Main.showInformation("Zapisywanie", "Zapisano ocenê.", AlertType.INFORMATION);
				}
			} catch (ClassNotFoundException | SQLException e) {
				Main.showInformation("Zapisywanie", "Zapisywanie zmian nie powiod³o siê.", AlertType.ERROR);
				e.printStackTrace();
			}
		}

	}
}
