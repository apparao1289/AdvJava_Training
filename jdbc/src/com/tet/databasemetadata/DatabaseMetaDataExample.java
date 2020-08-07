package com.tet.databasemetadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.test.utils.ConnectionUtils;

public class DatabaseMetaDataExample {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("UserName: " + dbmd.getUserName());
			System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}
