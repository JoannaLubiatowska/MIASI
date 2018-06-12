package application.service;

import java.sql.SQLException;

import application.entity.Profesors;
import application.exception.WrongEmailFormatException;

public class LoginService {

	private ProfesorService profesorService = new ProfesorService();
	private Profesors currentUser;
	
	public boolean signIn(String login, String password) throws WrongEmailFormatException, ClassNotFoundException, SQLException {
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
