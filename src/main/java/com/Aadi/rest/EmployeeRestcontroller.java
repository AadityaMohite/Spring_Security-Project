package com.Aadi.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Aadi.Service.*;

import com.Aadi.dto.EmployeeDto;
import com.Aadi.entity.Employee;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeRestcontroller {

	private final EmployeeService employeeService;
	
	public EmployeeRestcontroller(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<EmployeeDto> saveemployee(@RequestBody EmployeeDto employeeDto) {
		
		            EmployeeDto employeeDto2    =   employeeService.saveemployee(employeeDto);
		            
		            
		            return new ResponseEntity<EmployeeDto>(employeeDto2,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getallemployees(){
	List<Employee> employees =	employeeService.getEmployees();
	
	return new  ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeByid(@PathVariable Integer id){
	Employee  employee =	employeeService.getEmployeeByID(id);
	
	return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto>updateEmployeeByid(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
		                               
		               EmployeeDto   employeeDto2   =     employeeService.updateEmployeeByID(id, employeeDto);
		               
		               return new ResponseEntity<EmployeeDto>(employeeDto2,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteemployeeByid(@PathVariable  Integer id)
	{
		              String  msg   =      employeeService.deleteEmployeeByid(id);
		              
		              return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/byfirstname")
	public ResponseEntity<List<Employee>> getemployeebyfirstname(@RequestParam String firstname){
		
		firstname = firstname.trim();
		
	List<Employee> employee =	employeeService.EmployeeByfirstname(firstname);
	
	return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/bydesignation")
	public ResponseEntity<List<Employee>> getEmployeebydesignation(@RequestParam String designation){
		
		System.out.println("[" + designation + "]");
		
		designation = designation.trim();
		
	List<Employee> employees =	employeeService.getEmployeeBydesignation(  designation);
	
	return  new ResponseEntity<List<Employee>> (employees,HttpStatus.OK);
		
	}
	
	@GetMapping("/byage")
	public ResponseEntity<List<Employee>> getemployeeByage(@RequestParam Integer age){
		List<Employee> employees =  employeeService.getEmployeeByage(age);
		
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		
	}
}
