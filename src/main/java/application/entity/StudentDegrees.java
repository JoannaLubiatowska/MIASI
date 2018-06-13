package application.entity;

import java.sql.Date;

public class StudentDegrees {

	private Integer studentDegreesID;
	private Integer examID;
	private Integer profesorID;
	private Integer studentID;
	private int resultPunctation;
	//private float degree;
	private Date dateOfDegree;
	
	public StudentDegrees(Integer studentDegreesID, Integer examID, Integer profesorID, Integer studentID,
			int resultPunctation, Date dateOfDegree) {
		super();
		this.studentDegreesID = studentDegreesID;
		this.examID = examID;
		this.profesorID = profesorID;
		this.studentID = studentID;
		this.resultPunctation = resultPunctation;
		//this.degree = degree;
		this.dateOfDegree = dateOfDegree;
	}
//	public float getDegree() {
//		return degree;
//	}
//	public void setDegree(float degree) {
//		this.degree = degree;
//	}
	public Integer getStudentDegreesID() {
		return studentDegreesID;
	}
	public void setStudentDegreesID(Integer studentDegreesID) {
		this.studentDegreesID = studentDegreesID;
	}
	public Integer getExamID() {
		return examID;
	}
	public void setExamID(Integer examID) {
		this.examID = examID;
	}
	public Integer getProfesorID() {
		return profesorID;
	}
	public void setProfesorID(Integer profesorID) {
		this.profesorID = profesorID;
	}
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	public int getResultPunctation() {
		return resultPunctation;
	}
	public void setResultPunctation(int resultPunctation) {
		this.resultPunctation = resultPunctation;
	}
	public Date getDateOfDegree() {
		return dateOfDegree;
	}
	public void setDateOfDegree(Date dateOfDegree) {
		this.dateOfDegree = dateOfDegree;
	}
}
