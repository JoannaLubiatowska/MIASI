package application.converter;

import java.sql.ResultSet;

import application.entity.Exams;

public class ResultSetToExamConverter implements ResultSetConverter<Exams> {

	@Override
	public Exams convert(ResultSet resultSet) {
		try {
			Integer examID = resultSet.getInt("ExamID");
			String examName = resultSet.getString("ExamName");
			Integer subjectID = resultSet.getInt("SubjectID");
			Integer maxPunctation = resultSet.getInt("MaxPunctation");
			return new Exams(examID, examName, subjectID, maxPunctation);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
