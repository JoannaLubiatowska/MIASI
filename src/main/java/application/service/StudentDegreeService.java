package application.service;

import java.sql.SQLException;
import java.sql.Statement;

import application.Main;
import application.entity.StudentDegrees;

public class StudentDegreeService {
	
	private ResultPunctator resultPunctator = new ResultPunctator();
	private ExamService examService = new ExamService();

	public boolean saveNewDegree(StudentDegrees degree) throws ClassNotFoundException, SQLException {
		String insert = String.format("INSERT INTO StudentDegrees(ExamID, ProfesorID, StudentID, Degree, ResultPunctation) VALUES(%d, %d, %d, %d, %d)",
				degree.getExamID(), degree.getProfesorID(), degree.getStudentID(), /*resultPunctator.getDegree(examService.getExamById(degree.getExamID()), degree.getResultPunctation())*/5, degree.getResultPunctation());
		int result = 0;

		try (Statement statement = Main.getStatement()) {
			result = statement.executeUpdate(insert);
		}
		
		return result == 1;
	}
}
