package com.sms.model;

import java.util.List;

import com.sms.entities.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO 
{

	private int Id;
	private String name;
	private String address;
	private String phNo;
	
	List<Student> students;
}
