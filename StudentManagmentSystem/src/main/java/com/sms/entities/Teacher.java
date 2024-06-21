package com.sms.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(length =20 )
	private String name;
	@Column(length = 30)
	private String address;
	@Column(unique = true)
	private String phNo;
	
	//one teacher can teach many students
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("teacher")
	List<Student> students;
}
