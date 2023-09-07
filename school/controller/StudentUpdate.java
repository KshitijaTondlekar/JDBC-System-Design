package com.school.controller;

import com.school.service.StudentService;

public class StudentUpdate {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		boolean res = studentService.updateStudent(2);
		System.out.println(res);
	}

}
