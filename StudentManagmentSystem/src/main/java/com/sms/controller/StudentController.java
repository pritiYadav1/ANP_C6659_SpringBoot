package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entities.Student;
import com.sms.model.StudentDTO;
import com.sms.service.StudentService;
import com.sms.utitity.Converter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class StudentController 
{
	@Autowired
	StudentService studentService;
	@Autowired
	Converter converter;
	@PostMapping("/createStudent")
	ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDto )
	{
		final Student student=converter.convertToStudentEntity(studentDto);
		return new ResponseEntity<StudentDTO>(studentService.createStudent(student),HttpStatus.CREATED);
	}
	@GetMapping("/getAllstudents")
	List<StudentDTO> getAllStudents()
	{
		return studentService.getAllStudents();		
	}
	@GetMapping("/getStudentById/{sid}")
	StudentDTO getStudentById(@PathVariable("sid") int id)
	{
		return studentService.getStudentById(id);
	}
	@DeleteMapping("/deleteStudent/{sid}")
	String deleteStudentById(@PathVariable("sid") int id)
	{
		return studentService.deleteStudentById(id);
	}
	@PutMapping("/updateStudent/{sid}")
	StudentDTO updateStudent(@Valid @PathVariable("sid") int id,@RequestBody Student student)
	{
		return studentService.updateStudent(id, student);
	}
	
	
	
}
