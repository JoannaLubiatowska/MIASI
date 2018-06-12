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

}
