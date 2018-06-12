package application.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import application.Main;
import application.converter.ResultSetToExamConverter;
import application.entity.Exams;

public class ExamService {

	private ResultSetToExamConverter converter = new ResultSetToExamConverter();

	public Collection<Exams> getAllExams() throws ClassNotFoundException, SQLException {
		Collection<Exams> allExams = new ArrayList<>();

		try (Statement statement = Main.getStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Exams ORDER BY ExamName")) {
			while (resultSet.next()) {
				allExams.add(converter.convert(resultSet));
			}
		}

		return allExams;
	}

	public boolean saveNewExam(Exams exam) throws ClassNotFoundException, SQLException {
		String insert = String.format("INSERT INTO Exams(ExamName, SubjectID, MaxPunctation) VALUES('%s', %d, %d)",
				exam.getExamName(), exam.getSubject(), exam.getMaxPunctation());
		int result = 0;

		try (Statement statement = Main.getStatement()) {
			result = statement.executeUpdate(insert);
		}
		
		return result == 1;
	}

	public Exams getExamById(Integer examID) throws ClassNotFoundException, SQLException {
		Exams allExams = null;
		String query = String.format("SELECT * FROM Exams WHERE ExamID = %d ORDER BY ExamName", examID);

		try (Statement statement = Main.getStatement();
				ResultSet resultSet = statement.executeQuery(query)) {
			while (resultSet.next()) {
				allExams = converter.convert(resultSet);
			}
		}

		return allExams;
	}

}
