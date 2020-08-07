package com.test.callablestatement;

import com.test.exception.ApplicationException;

public interface EmployeeDao {
	
	int getEmployeeSalaryById(int id) throws ApplicationException;

}
