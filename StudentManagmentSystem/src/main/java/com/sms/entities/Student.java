package com.sms.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student_details")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="studid",length =20)
	private int Id;
	@Column(name="studname",length =20)
	private String name;
	@Column(name="studadd",length =20)
	private String address;
	@Column(name="studphno",length =10)
	private String phNo;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="tId")
	@JsonIgnoreProperties("students")
	private Teacher teacher;
}
