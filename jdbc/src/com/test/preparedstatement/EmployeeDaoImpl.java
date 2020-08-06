package com.test.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			PreparedStatement psmt = con.prepareStatement("select * from employee");
			ResultSet rs = psmt.executeQuery();
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
			PreparedStatement psmt = con.prepareStatement("select * from employee where eid=?");
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
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
		int effectedRows = 0;
		try {
			con = ConnectionUtils.getConnection();
			PreparedStatement psmt = con.prepareStatement("insert into employee (eid,ename,job,sal,comm,deptno,mgr,hiredate) values(?,?,?,?,?,?,?,?)");
			psmt.setInt(1, e.getId());
			psmt.setString(2, e.getName());
			psmt.setString(3, e.getJob());
			psmt.setInt(4, e.getSalary());
			psmt.setInt(5, e.getCommission());
			psmt.setInt(6, e.getDeptNo());
			psmt.setInt(7, e.getMgr());
			psmt.setDate(8, e.getHireDate());
			
			effectedRows = psmt.executeUpdate();
			
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
		int effectedRows = 0;
		try {
			con = ConnectionUtils.getConnection();
			PreparedStatement psmt = con.prepareStatement("update employee set sal = ? where eid=?");
			psmt.setInt(1, salary);
			psmt.setInt(2, id);
			effectedRows = psmt.executeUpdate();
			
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
		int effectedRows = 0;
		try {
			con = ConnectionUtils.getConnection();
			PreparedStatement psmt = con.prepareStatement("delete from employee where eid =?");
			psmt.setInt(1, id);
			effectedRows = psmt.executeUpdate();
			
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		} finally {
			ConnectionUtils.closeResoure(con);
		}
		
		return effectedRows;
	}

}
