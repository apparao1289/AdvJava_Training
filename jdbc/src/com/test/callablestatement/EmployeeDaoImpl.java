package com.test.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.test.exception.ApplicationException;
import com.test.utils.ConnectionUtils;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int getEmployeeSalaryById(int id) throws ApplicationException {
		// Create connection.
		Connection conn = null;
		int salary = 0;
		try {
			conn = ConnectionUtils.getConnection();
			CallableStatement csmt = conn.prepareCall("{call getEmpSal(?,?)}"); 
			csmt.setInt(1, id);
			csmt.registerOutParameter(2, java.sql.Types.INTEGER);
			csmt.execute();
			salary = csmt.getInt(2);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return salary;
	}

}
