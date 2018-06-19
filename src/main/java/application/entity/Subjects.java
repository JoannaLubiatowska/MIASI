package application.entity;

import java.io.Serializable;

public class Subjects implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6685735191025984325L;
	private Integer subjectID;
	private String subjectName;
		
	public Subjects(Integer subjectId, String subjectName) {
		super();
		this.subjectID = subjectId;
		this.subjectName = subjectName;
	}
	
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@Override
	public String toString() {
		return this.subjectName;
	}
}
