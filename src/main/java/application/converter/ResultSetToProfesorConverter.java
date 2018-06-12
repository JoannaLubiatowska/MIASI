package application.converter;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.entity.Profesors;

public class ResultSetToProfesorConverter implements ResultSetConverter<Profesors> {

	@Override
	public Profesors convert(ResultSet resultSet) {				
		try {
			Integer profesorId = resultSet.getInt("ProfesorID");
			String firstName = resultSet.getString("FirstName");
			String lastName = resultSet.getString("LastName");
			String UserLogin = resultSet.getString("UserLogin");
			Integer userGroupId = resultSet.getInt("UserGroupID");
			
			return new Profesors(profesorId, firstName, lastName, UserLogin, userGroupId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
