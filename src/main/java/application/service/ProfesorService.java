package application.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Main;
import application.converter.ResultSetToProfesorConverter;
import application.entity.Profesors;

public class ProfesorService {

	private ResultSetToProfesorConverter converter = new ResultSetToProfesorConverter();

	public Profesors getUserByCredentials(String login, String password) throws ClassNotFoundException, SQLException {
		Profesors profesor = null;
		
		String query = String.format("SELECT * FROM Profesors WHERE UserLogin = '%s' AND UserPassword = '%s'", login, password);

		try (Statement statement = Main.getStatement();
				ResultSet resultSet = statement.executeQuery(query)) {
			while (resultSet.next()) {
				profesor = converter.convert(resultSet);
			}
		}
		return profesor;
	}

}
