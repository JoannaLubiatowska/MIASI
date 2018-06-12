package application.converter;

import java.sql.ResultSet;

import application.entity.Students;

public class ResultSetToStudentConverter implements ResultSetConverter<Students> {

	@Override
	public Students convert(ResultSet resultSet) {
		try {
			Integer studentID = resultSet.getInt("StudentID");
			String firstName = resultSet.getString("FirstName");
			String lastName = resultSet.getString("LastName");
			int indexNumber = resultSet.getInt("IndexNumber");
			String UserLogin = resultSet.getString("UserLogin");
			Integer userGroupId = resultSet.getInt("UserGroupID");
			
			return new Students(studentID, firstName, lastName, indexNumber, UserLogin, userGroupId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
