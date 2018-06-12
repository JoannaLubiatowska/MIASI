package application.converter;

import java.sql.ResultSet;

import application.entity.Subjects;

public class ResultSetToSubjectConverter implements ResultSetConverter<Subjects> {

	@Override
	public Subjects convert(ResultSet resultSet) {
		try {
			Integer subjectId = resultSet.getInt("SubjectID");
			String subjectName = resultSet.getString("SubjectName");
			
			return new Subjects(subjectId, subjectName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
