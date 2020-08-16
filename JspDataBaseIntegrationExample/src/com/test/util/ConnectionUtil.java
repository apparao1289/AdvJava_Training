package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.test.exception.ApplicationException;

public class ConnectionUtil {

	public static Connection getConnection() throws ApplicationException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
		return conn;
	}

	public static void closeResources(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
