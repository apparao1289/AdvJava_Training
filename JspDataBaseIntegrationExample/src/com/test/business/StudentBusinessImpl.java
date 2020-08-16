package com.test.business;

import com.test.dao.StudentDao;
import com.test.dao.StudentDaoImpl;
import com.test.exception.ApplicationException;
import com.test.model.Student;

public class StudentBusinessImpl implements StudentBusiness {

	@Override
	public boolean createStudent(Student student) throws ApplicationException {

		StudentDao studentDao = new StudentDaoImpl();

		// Generate the id.
		int maxId = studentDao.getMaxStudentId();

		if (maxId > 0) {
			student.setId(maxId + 1);
		}

		// invoke the create student method.
		boolean status = studentDao.createStudent(student);

		return status;
	}

}
