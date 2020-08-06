package com.test.testdaos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.test.exception.ApplicationException;
import com.test.model.Employee;
import com.test.statement.EmployeeDao;
import com.test.statement.EmployeeDaoImpl;

public class SatementTest {

	public static void main(String[] args) throws ApplicationException {
		getAllEmployeeTest();
		//getEmployeeTest(1);
		//updateEmployeeTest(1,4000);
		//deleteEmployee(4);
		//createEMployeeTest();
	}

	private static void createEMployeeTest() throws ApplicationException {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee e = new Employee();
		e.setId(8);
		e.setName("Suresh");
		e.setJob("SSE");
		e.setSalary(6000);
		e.setCommission(1000);
		Date date = new Date();
		e.setHireDate(null);
		e.setDeptNo(2);
		e.setMgr(5);
		
		boolean result = employeeDao.createEmployee(e);
		if(result) {
			System.out.println("Employee created successfully.");
		} else {
			System.out.println("Employee is not created.");
		}
	}

	private static void deleteEmployee(int id) throws ApplicationException {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		int deletedRowCount = employeeDao.deleteEmployeeById(id);
		System.out.println("No of deleted rows are ::"+deletedRowCount);
	}

	private static void updateEmployeeTest(int id,int salary) throws ApplicationException {
		EmployeeDao empDao = new EmployeeDaoImpl();
		int effectedRows= empDao.updateEmployeeById(id, salary);
		System.out.println("effected rows are ::"+effectedRows);
	}

	private static void getEmployeeTest(int id) throws ApplicationException {
		EmployeeDao empDao = new EmployeeDaoImpl();
		Employee e = empDao.getEmployeeById(id);
		
		System.out.println("Employee details::");
		System.out.println("Id:" + e.getId());
		System.out.println("Name:" + e.getName());
		System.out.println("Job:" + e.getJob());
		System.out.println("salary:" + e.getSalary());
		System.out.println("Commission:" + e.getCommission());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String hireDate = sdf.format(e.getHireDate());
		System.out.println("Hire date:" +hireDate );
		System.out.println("\n");
	}

	private static void getAllEmployeeTest() throws ApplicationException {
		EmployeeDao empDao = new EmployeeDaoImpl();
		List<Employee> empList = empDao.getAllEmployeeDetails();
		for (Employee e : empList) {
			System.out.println("Employee details::");
			System.out.println("Id:" + e.getId());
			System.out.println("Name:" + e.getName());
			System.out.println("Job:" + e.getJob());
			System.out.println("salary:" + e.getSalary());
			System.out.println("Commission:" + e.getCommission());
			System.out.println("Hire date:" + e.getHireDate());
			System.out.println("\n");
		}
	}

}
