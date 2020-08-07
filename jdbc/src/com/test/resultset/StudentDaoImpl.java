package com.test.resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.exception.ApplicationException;
import com.test.model.Student;
import com.test.utils.ConnectionUtils;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAllStudents() throws ApplicationException {
		Connection conn = null;
		Student student = null;
		List<Student> studentList = new ArrayList<Student>();
		try {
			conn = ConnectionUtils.getConnection();
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select id,name,age, address, stand from student");
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setAddress(rs.getString(4));
				student.setStand(rs.getString(5));
				studentList.add(student);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}finally {
			ConnectionUtils.closeResoure(conn);
		}

		return studentList;
	}

	@Override
	public void getStudents() throws ApplicationException {

		Connection conn = ConnectionUtils.getConnection();
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select id,name,age, address, stand from student");

			System.out.println("Before updating the age::");
			printResultSet(rs);

			rs.beforeFirst();
			while (rs.next()) {
				int age = rs.getInt("age") + 2;
				rs.updateInt("age", age);
				rs.updateRow();
			}

			System.out.println("After updating the age::");
			printResultSet(rs);

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}finally {
			ConnectionUtils.closeResoure(conn);
		}
	}

	private void printResultSet(ResultSet rs) throws SQLException {
		Student student = null;
		while (rs.next()) {
			student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setAge(rs.getInt("age"));
			student.setAddress(rs.getString("address"));
			student.setStand(rs.getString("stand"));
			System.out.println("Student details::" + student.toString());
		}
	}

}
