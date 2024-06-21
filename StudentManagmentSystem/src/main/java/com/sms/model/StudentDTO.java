package com.sms.model;

import com.sms.entities.Teacher;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDTO 
{
	@NotNull
	private int Id;
	@NotBlank
	@Size(min = 2,max = 20, message = "Name should contain only min 2 to max 30 character")
	private String name;
	@NotBlank
	@Size(min=2,max=20,message = "Address should contain only 2 to 20 character")
	private String address;
	@NotBlank
	@Column(unique =true)
	@Size(min=2,max=10,message = "The phone number should contain only 10 digit ")
	private String phNo;
	private Teacher teacher;

}
