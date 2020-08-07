package com.test.resultsetmetadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.test.utils.ConnectionUtils;

public class ResultSetMetaDataExample {

	public static void main(String[] args) throws SQLException {

		Connection con = ConnectionUtils.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement("select * from employee");
			ResultSet rs = psmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("Total columns: " + rsmd.getColumnCount());
			for (int index = 1; index <= rsmd.getColumnCount(); index++) {
				System.out.println("Column Name of 1st column: " + rsmd.getColumnName(index));
				System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(index));
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
