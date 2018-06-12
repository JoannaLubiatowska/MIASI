package application.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import application.Main;
import application.converter.ResultSetToSubjectConverter;
import application.entity.Subjects;

public class SubjectService {

	private ResultSetToSubjectConverter converter = new ResultSetToSubjectConverter();

	public Collection<Subjects> getAllSubjects() throws ClassNotFoundException, SQLException {
		Collection<Subjects> allSubjects = new ArrayList<>();
		
		try (Statement statement = Main.getStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Subjects ORDER BY 2")) {
			while (resultSet.next()) {
				allSubjects.add(converter.convert(resultSet));
			}
		}
		return allSubjects;
	}
}
