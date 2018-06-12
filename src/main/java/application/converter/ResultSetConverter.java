package application.converter;

import java.sql.ResultSet;

public interface ResultSetConverter<T> {
	T convert(ResultSet resultSet);
}
