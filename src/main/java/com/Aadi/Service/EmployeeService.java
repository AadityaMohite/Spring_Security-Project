package com.Aadi.Service;

import java.util.List;
import java.util.Optional;

import com.Aadi.dto.EmployeeDto;
import com.Aadi.entity.Employee;

public interface EmployeeService {

	EmployeeDto saveemployee(EmployeeDto employeeDto);
	
List<Employee>	getEmployees();

Employee  getEmployeeByID(Integer id);

EmployeeDto updateEmployeeByID(Integer id, EmployeeDto employeeDto);

String  deleteEmployeeByid(Integer id);

 List<Employee>    EmployeeByfirstname(String firstname);
 
List<Employee> getEmployeeBydesignation(String designation);

      List<Employee> getEmployeeByage(Integer age);
      
      List<Employee> getEmployeeByaddress( String address);
	
}
