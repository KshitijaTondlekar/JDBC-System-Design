package com.school.controller;

import com.school.dto.Teacher;
import com.school.service.TeacherService;

public class TeacherController {
	public static void main(String[] args) {
		Teacher teacher=new Teacher();
		teacher.setId(2);
		teacher.setName("Kshitija");
		teacher.setEmail("kshi@mail.com");
		TeacherService teacherservice=new TeacherService();
		Teacher t=teacherservice.saveTeacher(teacher);
		if(t!=null) {
			System.out.println(t.getId()+"Save successfully");
		}
		
	}

}
