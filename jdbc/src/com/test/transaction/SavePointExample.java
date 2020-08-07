package com.test.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.test.utils.ConnectionUtils;

public class SavePointExample {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Savepoint savepint = null;
		try {
			System.out.println("Execution process is starting..");
			
			conn = ConnectionUtils.getConnection();
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			
			String sql1 = "INSERT INTO employee(eid,ename,job,sal,comm,deptno,mgr) VALUES (40,'Ram', 'SSE',2000,100,1,2)";
			stmt.executeUpdate(sql1);
			
			savepint = conn.setSavepoint("savepoint1");
			
			String sql2 = "UPDATE employee SET SAL=10000 WHERE SAL < 8000";
			stmt.executeUpdate(sql2);
			
			String sql3 = "delete from employee where eid = 20";
			stmt.executeUpdate(sql3);
			
			conn.commit();
			System.out.println("Execution process is complete..");
			conn.commit();
		} catch (SQLException se) {
			conn.rollback(savepint);
			se.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
