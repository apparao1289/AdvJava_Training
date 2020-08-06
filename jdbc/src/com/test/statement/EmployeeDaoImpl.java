package com.test.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.exception.ApplicationException;
import com.test.model.Employee;
import com.test.utils.ConnectionUtils;

/**
 * This class having information about the employee.
 * 
 * @author apparao
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {

	/* (non-Javadoc)
	 * @see com.test.statement.EmployeeDao#getAllEmployeeDetails()
	 */
	@Override
	public List<Employee> getAllEmployeeDetails() throws ApplicationException {

		Connection con = null;
		List<Employee> empList = new ArrayList<>();
		Employee emp = null;
		try {
			con = ConnectionUtils.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			while (rs.next()) {
				emp = new Employee();
				emp.setId(rs.getInt("eid"));
				emp.setName(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSalary(rs.getInt("sal"));
				emp.setCommission(rs.getInt("comm"));
				emp.setHireDate(rs.getDate("hiredate"));
				empList.add(emp);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			ConnectionUtils.closeResoure(con);
		}

		return empList;
	}

	/* (non-Javadoc)
	 * @see com.test.statement.EmployeeDao#getEmployeeById(int)
	 */
	@Override
	public Employee getEmployeeById(int id) throws ApplicationException {
		
		Connection con = null;
		Employee emp = null;
		try {
			con = ConnectionUtils.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee where eid="+id);
			while (rs.next()) {
				emp = new Employee();
				emp.setId(rs.getInt("eid"));
				emp.setName(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSalary(rs.getInt("sal"));
				emp.setCommission(rs.getInt("comm"));
				emp.setHireDate(rs.getDate("hiredate"));
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			ConnectionUtils.closeResoure(con);
		}
		
		return emp;
	}

	/* (non-Javadoc)
	 * @see com.test.statement.EmployeeDao#createEmployee(com.test.statement.Employee)
	 */
	@Override
	public boolean createEmployee(Employee e) throws ApplicationException {
		Connection con = null;
		Statement stmt = null;
		int effectedRows = 0;
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			StringBuilder query = new StringBuilder("insert into employee (eid,ename,job,sal,comm,deptno,mgr,hiredate) values(");
			query.append(e.getId()).append(",").append("'");
			query.append(e.getName()).append("'").append(",").append("'");
			query.append(e.getJob()).append("'").append(",");
			query.append(e.getSalary()).append(",");
			query.append(e.getCommission()).append(",");
			query.append(e.getDeptNo()).append(",");
			query.append(e.getMgr()).append(",");
			query.append(e.getHireDate()).append(")");
			System.out.println("query::"+query.toString());
			effectedRows = stmt.executeUpdate(query.toString());
			
		} catch (Exception exception) {
			throw new ApplicationException(exception.getMessage());
		} finally {
			ConnectionUtils.closeResoure(con);
		}
		
		return effectedRows > 0 ? true:false;
		
	}

	/* (non-Javadoc)
	 * @see com.test.statement.EmployeeDao#updateEmployeeById(int, int)
	 */
	@Override
	public int updateEmployeeById(int id, int salary) throws ApplicationException {
		Connection con = null;
		Statement stmt = null;
		int effectedRows = 0;
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			effectedRows = stmt.executeUpdate("update employee set sal = "+salary+" where eid="+id);
			
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			ConnectionUtils.closeResoure(con);
		}
		
		return effectedRows;
	}

	/* (non-Javadoc)
	 * @see com.test.statement.EmployeeDao#deleteEmployeeById(int)
	 */
	@Override
	public int deleteEmployeeById(int id) throws ApplicationException {
		
		Connection con = null;
		Statement stmt = null;
		int effectedRows = 0;
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			effectedRows = stmt.executeUpdate("delete from employee where eid ="+id);
			
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			ConnectionUtils.closeResoure(con);
		}
		
		return effectedRows;
	}

}
