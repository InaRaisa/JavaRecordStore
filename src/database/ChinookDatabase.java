package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChinookDatabase {
	public static final String DATABASE_URL = "jdbc:sqlite:C:\\Users\\ina_p_000\\Desktop\\Ohjelmointi 2019\\sqlite\\Chinook_Sqlite.sqlite";
	
	public Connection connect() {
		try {
			// Force loading to SQLite driver
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(DATABASE_URL);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void close(ResultSet results, PreparedStatement statement, Connection connection) {
		try {
			if (results != null ) {
				results.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (connection != null)  {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
