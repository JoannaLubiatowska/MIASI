package application.entity;

import java.io.Serializable;

public class Students implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7608591208770885100L;
	private Integer studentID;
	private String fFirstName;
	private String lastName;
	private int indexNumber;
	private String userLogin;
	private String userPassword;
	private Integer userGroup;
	
	public Students(Integer studentID, String fFirstName, String lastName, int indexNumber, String userLogin,
			Integer userGroup) {
		super();
		this.studentID = studentID;
		this.fFirstName = fFirstName;
		this.lastName = lastName;
		this.indexNumber = indexNumber;
		this.userLogin = userLogin;
		this.userGroup = userGroup;
	}
	
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
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
	public int getIndexNumber() {
		return indexNumber;
	}
	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
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
	
	@Override
	public String toString() {
		return String.format("%s %s (%d)", lastName, fFirstName, indexNumber);
	}
}
