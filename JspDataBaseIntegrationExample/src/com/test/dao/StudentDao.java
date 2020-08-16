package com.test.dao;

import com.test.exception.ApplicationException;
import com.test.model.Student;

public interface StudentDao {

	/**
	 * This method used to create the student, based on given student information.
	 * 
	 * @param student
	 * @return
	 * @throws ApplicationException
	 */
	boolean createStudent(Student student) throws ApplicationException;

	/**
	 * This method fetches the maximum student id form student table.
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	int getMaxStudentId() throws ApplicationException;
	
}
