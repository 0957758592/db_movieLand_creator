package com.movieland.databasecreator.service;

import java.sql.*;

public class TableCreator {
	private static final String DB_PATH = "jdbc:mysql://localhost:3306/movieland?useUnicode=yes&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST";

	public static void createTable(String sql, String SQL_Table) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DB_PATH, "root", "");
		     PreparedStatement statement = connection.prepareStatement(sql);
		     PreparedStatement tableStatement = connection.prepareStatement(SQL_Table)) {

			tableStatement.execute();
			statement.execute();
		}
	}

}
