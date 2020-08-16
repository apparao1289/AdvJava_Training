package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.exception.ApplicationException;
import com.test.model.Student;
import com.test.util.ConnectionUtil;

public class StudentDaoImpl implements StudentDao {

	/* (non-Javadoc)
	 * @see com.test.dao.StudentDao#createStudent(com.test.model.Student)
	 */
	@Override
	public boolean createStudent(Student student) throws ApplicationException {

		Connection conn = ConnectionUtil.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement("insert into student(id,name,age,address,stand) values(?,?,?,?,?)");
			psmt.setInt(1, student.getId());
			psmt.setString(2, student.getFname()+" "+student.getLname());
			psmt.setInt(3, student.getAge());
			psmt.setString(4, student.getAddress());
			psmt.setString(5, student.getStand());
			int result = psmt.executeUpdate();
			return result > 0 ? true:false;
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}finally {
			ConnectionUtil.closeResources(conn);
		}
	}

	/* (non-Javadoc)
	 * @see com.test.dao.StudentDao#getMaxStudentId()
	 */
	@Override
	public int getMaxStudentId() throws ApplicationException {

		Connection conn = ConnectionUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(id) from student");
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
		return 0;
	}

}
