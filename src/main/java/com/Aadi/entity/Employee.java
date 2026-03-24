package com.Aadi.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstname;
	
	private String lastname;
	
	private String gender;
	
	@Column(unique = true)
	private String email;
	
	private String mobileno;
	
	private String dep;
	
	private Double Salary;
	
	private LocalDate joiningDate;
	
	private LocalDate DoB;
	
	private String designation;
	
	private Boolean isMarried;
	
	private Boolean status;
	
	private Integer experience;
	
	private String educationqualification;
	
	private String address;
	
	private Integer age;
	
	
	
	
	
	
	
}
