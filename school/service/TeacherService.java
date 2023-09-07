package com.school.service;

import com.school.dao.TeacherDao;
import com.school.dto.Teacher;

public class TeacherService {
	TeacherDao teacherDao= new TeacherDao();
	public Teacher saveTeacher(Teacher teacher){
		return teacherDao.saveTeacher(teacher);
	}
	
	public boolean  deleteTeacher(int id) {
		return teacherDao.deleteTeacher(id);
	}
	
	public void retrieveTeacher() {
	teacherDao.retrieveTeacher();	
	}
	
	public boolean updateTeacher(int id) {
		return teacherDao.updateTeacher(id);
	}
	}
	


