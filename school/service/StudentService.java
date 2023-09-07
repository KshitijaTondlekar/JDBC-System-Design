package com.school.service;

import java.sql.ResultSet;

import com.school.dao.StudentDao;
import com.school.dto.Student;

public class StudentService {
	
	StudentDao studentDao = new StudentDao();
	
	public Student saveStudent(Student student) {
		Student s= studentDao.saveStudent(student);
		return s;
		
	}
	public boolean  deleteStudent(int idt) {
		return studentDao.deleteStudent(idt);
		
		
	}
	public boolean updateStudent(int idt) {
		return studentDao.updateStudent(idt);
	}
	public void retrieveStudent() {
		studentDao.retrieveStudent();
	//System.out.println();studentDao.retrieveStudent();
	}
	}


