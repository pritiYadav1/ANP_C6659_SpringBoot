package com.sms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entities.Student;
import com.sms.entities.Teacher;
import com.sms.exceptions.ResourceNotFoundException;
import com.sms.model.TeacherDTO;
import com.sms.repository.StudentRepository;
import com.sms.repository.TeacherRepository;
import com.sms.service.TeacherService;
import com.sms.utitity.Converter;
@Service
public class TeacherServiceImpl implements TeacherService
{
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private Converter converter;
	
	@Override
	public TeacherDTO registerTeacher(Teacher teacher) 
	{
		// TODO Auto-generated method stub
		return converter.convertToTeacherDTO(teacherRepository.save(teacher));
	}

	@Override
	public String assignStudentToTeacher(int tid, int sid) 
	{
		Student s= studentRepository.findById(sid).orElseThrow(()->
		new ResourceNotFoundException("Student", "Id", sid));
		
		Teacher t=teacherRepository.findById(tid).orElseThrow(()->
		new ResourceNotFoundException("Teacher", "Id", tid));
		
		List<Student> students=new ArrayList<>();
		students.add(s);
		
		t.setStudents(students);
		s.setTeacher(t);
		teacherRepository.save(t);
		return "Student assign to the teacher successfullyyyy";
	}

}
