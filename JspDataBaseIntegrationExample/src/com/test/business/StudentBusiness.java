package com.test.business;

import com.test.exception.ApplicationException;
import com.test.model.Student;

public interface StudentBusiness {

	boolean createStudent(Student student) throws ApplicationException;
}
