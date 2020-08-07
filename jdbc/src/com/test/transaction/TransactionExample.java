package com.test.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.utils.ConnectionUtils;

public class TransactionExample {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			System.out.println("Execution process is starting..");
			conn = ConnectionUtils.getConnection();
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			String sql1 = "INSERT INTO employee(eid,ename,job,sal,comm,deptno,mgr) VALUES (20,'Ram', 'SSE',2000,100,1,2)";
			stmt.executeUpdate(sql1);
			String sql2 = "UPDATE employee SET SAL=10000 WHERE SAL < 5000";
			stmt.executeUpdate(sql2);
			conn.commit();
			System.out.println("Execution process is complete..");
		} catch (SQLException se) {
			conn.rollback();
			se.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
