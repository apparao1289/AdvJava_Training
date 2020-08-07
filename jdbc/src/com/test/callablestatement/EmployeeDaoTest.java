package com.test.callablestatement;

import com.test.exception.ApplicationException;

public class EmployeeDaoTest {

	public static void main(String[] args) throws ApplicationException {
		EmployeeDao empDao = new EmployeeDaoImpl();
		int salary = empDao.getEmployeeSalaryById(3);
		System.out.println("Employee salary::"+salary);
	}

}
