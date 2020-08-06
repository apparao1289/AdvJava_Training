package com.test.statement;

import java.sql.SQLException;
import java.util.List;

import com.test.exception.ApplicationException;
import com.test.model.Employee;

/**
 * This interface having all methods related to employee.
 * 
 * @author apparao
 *
 */
public interface EmployeeDao {

	/**
	 * This method fetches the all employee available in employee table.
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Employee> getAllEmployeeDetails() throws ApplicationException;

	/**
	 * This method fetches the employee details based on id.
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Employee getEmployeeById(int id) throws ApplicationException;

	/**
	 * This method create the employee based on provided values.
	 * 
	 * @param e
	 * @return
	 * @throws ApplicationException
	 */
	boolean createEmployee(Employee e) throws ApplicationException;

	/**
	 * This method update the employee salary based on given salary and id.
	 * 
	 * @param id
	 * @param salary
	 * @return
	 * @throws ApplicationException
	 */
	int updateEmployeeById(int id, int salary) throws ApplicationException;

	/**
	 * This method deletes the employee based on given id.
	 * 
	 * @param id
	 * @return
	 * @throws ApplicationException
	 */
	int deleteEmployeeById(int id) throws ApplicationException;

}
