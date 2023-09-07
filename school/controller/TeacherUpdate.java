package com.school.controller;

import com.school.service.TeacherService;

public class TeacherUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeacherService teacherService=new TeacherService();
		boolean res=teacherService.updateTeacher(2);
		System.out.println(res);

	}

}
