package com.Aadi.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeDto {

	
private String firstname;
	
	private String lastname;
	
	private String gender;
	
	private String dep;
	
	@Column(unique = true)
	private String email;
	
	private String mobileno;
	
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
