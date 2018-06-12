package application.entity;

public class Subjects {

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
		// TODO Auto-generated method stub
		return this.subjectName;
	}
}
