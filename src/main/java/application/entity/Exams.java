package application.entity;

public class Exams {

	private Integer examID;
	private String examName;
	private Integer subject;
	private Integer maxPunctation;
	
	public Exams(Integer examID, String examName, Integer subject, Integer maxPunctation) {
		super();
		this.examID = examID;
		this.examName = examName;
		this.subject = subject;
		this.maxPunctation = maxPunctation;
	}
	public Integer getExamID() {
		return examID;
	}
	public void setExamID(Integer examID) {
		this.examID = examID;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Integer getSubject() {
		return subject;
	}
	public void setSubject(Integer subject) {
		this.subject = subject;
	}
	public Integer getMaxPunctation() {
		return maxPunctation;
	}
	public void setMaxPunctation(Integer maxPunctation) {
		this.maxPunctation = maxPunctation;
	}
	
	@Override
	public String toString() {
		return this.examName;
	}
}
