package com.test.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.utils.ConnectionUtils;

public class BatchExample {

	public static void main(String[] args) throws SQLException {
		Connection conn = ConnectionUtils.getConnection();
		Statement stmt = null;
		try {
			System.out.println("Execution process is starting..");

			conn = ConnectionUtils.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			String sql1 = "INSERT INTO employee(eid,ename,job,sal,comm,deptno,mgr) VALUES (51,'Bob', 'SSE',2000,100,1,2)";
			stmt.addBatch(sql1);

			String sql2 = "UPDATE employee SET SAL=10000 WHERE SAL < 8000";
			stmt.addBatch(sql2);

			String sql3 = "delete from employee where eid = 20";
			stmt.addBatch(sql3);
			
			stmt.executeBatch();
			
			conn.commit();
			System.out.println("Execution process is complete..");
			conn.commit();
		} catch (SQLException se) {
			conn.rollback();
			se.printStackTrace();
		} finally {
			stmt.clearBatch();
			if (conn != null) {
				conn.close();
			}
		}
	}

}
