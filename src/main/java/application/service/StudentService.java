package application.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import application.Main;
import application.converter.ResultSetToStudentConverter;
import application.entity.Students;

public class StudentService {

	private ResultSetToStudentConverter converter = new ResultSetToStudentConverter();

	public Collection<Students> getAllStudents() throws ClassNotFoundException, SQLException {
		Collection<Students> allSubjects = new ArrayList<>();

		try (Statement statement = Main.getStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Students ORDER BY LastName")) {
			while (resultSet.next()) {
				allSubjects.add(converter.convert(resultSet));
			}
		}
		return allSubjects;
	}

}
