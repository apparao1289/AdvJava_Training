package com.test.resultset;

import java.util.List;

import com.test.exception.ApplicationException;
import com.test.model.Student;

public class StudentDaoTest {

	public static void main(String[] args) throws ApplicationException {
		// getAllStudentTest();
		getStudentByIdTest();
	}

	private static void getStudentByIdTest() throws ApplicationException {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.getStudents();
	}

	private static void getAllStudentTest() throws ApplicationException {
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> studenList = studentDao.getAllStudents();
		for (Student s : studenList) {
			System.out.println("Id:" + s.getId());
			System.out.println("Name:" + s.getName());
			System.out.println("Age:" + s.getAge());
			System.out.println("Address:" + s.getAddress());
			System.out.println("Stand:" + s.getStand());
			System.out.println("\n");
		}
	}

}
