package application.service;

import java.sql.SQLException;

import application.entity.Profesors;
import application.exception.WrongEmailFormatException;

public class LoginService {

	private static LoginService instance;

	private ProfesorService profesorService = new ProfesorService();
	private Profesors currentUser;

	public static LoginService instance() {
		if (instance == null) {
			instance = new LoginService();
		}

		return instance;
	}

	private LoginService() {
	}

	public boolean signIn(String login, String password)
			throws WrongEmailFormatException, ClassNotFoundException, SQLException {
		if (!login.toLowerCase().contains("@".toLowerCase())) {
			throw new WrongEmailFormatException();
		}

		return (this.currentUser = profesorService.getUserByCredentials(login, password)) != null;
	}

	public boolean signOut() {
		this.currentUser = null;
		return this.currentUser == null;
	}

	public Profesors getCurrentUser() {
		return this.currentUser;
	}
}
