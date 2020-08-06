package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EployeeTest {

	public static void main(String args[]) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select eid,ename,job from employee");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + "      " + rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
	}

}
