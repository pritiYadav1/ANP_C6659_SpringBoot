package com.sms.service;

import com.sms.entities.Teacher;
import com.sms.model.TeacherDTO;

public interface TeacherService 
{

	TeacherDTO registerTeacher(Teacher teacher);
	String assignStudentToTeacher(int tid,int sid);
}
