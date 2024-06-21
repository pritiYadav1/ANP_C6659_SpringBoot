package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entities.Teacher;
import com.sms.model.TeacherDTO;
import com.sms.service.TeacherService;
import com.sms.utitity.Converter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teacher")
public class TeacherController 
{
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private Converter converter;
	
	@PostMapping("/createTeacher")
	ResponseEntity<TeacherDTO> registerTeacher(@Valid @RequestBody TeacherDTO teacherDTO )
	{
		final Teacher teacher=converter.convertToTeacherEntity(teacherDTO);
		return new ResponseEntity<TeacherDTO>(teacherService.registerTeacher(teacher) ,HttpStatus.CREATED);
	}
	@PostMapping("/{tid}/{sid}")
	public String assignStudentToTeacher(@PathVariable("tid") int tid,
			@PathVariable("sid") int sid)
	{
		return teacherService.assignStudentToTeacher(tid, sid);	
	}
	
}
