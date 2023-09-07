package com.school.controller;

import com.school.service.StudentService;

public class StudentRetrieve {
public static void main(String[] args) {
	StudentService studentService = new StudentService();
	
	studentService.retrieveStudent();
	  
}
}
