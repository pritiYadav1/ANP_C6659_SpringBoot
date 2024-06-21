package com.sms.service;

import java.util.List;

import com.sms.entities.Student;
import com.sms.model.StudentDTO;

public interface StudentService 
{
	StudentDTO createStudent(Student student);
	List<StudentDTO> getAllStudents();
	StudentDTO getStudentById(int id);
	 String deleteStudentById(int id);
	 StudentDTO updateStudent(int id,Student student);
}
