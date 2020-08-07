package com.test.resultset;

import java.util.List;

import com.test.exception.ApplicationException;
import com.test.model.Student;

public interface StudentDao {

	public List<Student> getAllStudents() throws ApplicationException;
	
	void getStudents() throws ApplicationException;

}
