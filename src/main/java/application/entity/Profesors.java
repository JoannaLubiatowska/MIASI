package application.entity;

import java.io.Serializable;

public class Profesors implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1338616923945155449L;
	private Integer profesorID;
	private String fFirstName;
	private String lastName;
	private String userLogin;
	private String userPassword;
	private Integer userGroup;
	
	public Profesors(Integer profesorID, String fFirstName, String lastName, String userLogin, Integer userGroup) {
		super();
		this.profesorID = profesorID;
		this.fFirstName = fFirstName;
		this.lastName = lastName;
		this.userLogin = userLogin;
		this.userGroup = userGroup;
	}
	public Integer getProfesorID() {
		return profesorID;
	}
	public void setProfesorID(Integer profesorID) {
		this.profesorID = profesorID;
	}
	public String getfFirstName() {
		return fFirstName;
	}
	public void setfFirstName(String fFirstName) {
		this.fFirstName = fFirstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(Integer userGroup) {
		this.userGroup = userGroup;
	}	
}
