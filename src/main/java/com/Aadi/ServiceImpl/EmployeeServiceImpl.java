package com.Aadi.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.Aadi.Service.EmployeeService;
import com.Aadi.dto.EmployeeDto;
import com.Aadi.entity.Employee;
import com.Aadi.execption.EmployeeNotFoundException;
import com.Aadi.repo.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	

	@Override
	public EmployeeDto saveemployee(EmployeeDto employeeDto) {

	    // DTO → Entity
	    Employee employee = new Employee();
	    BeanUtils.copyProperties(employeeDto, employee);

	    // Save
	    Employee savedEmployee = employeeRepository.save(employee);

	    // Entity → DTO
	    BeanUtils.copyProperties(savedEmployee, employeeDto);

	    return employeeDto;
	}

	@Override
	public List<Employee> getEmployees() {
		         List<Employee> employees      =      employeeRepository.findAll();
		         
		         if(!employees.isEmpty()) {
		        	return employees ;
		         }else {
		        	 throw new EmployeeNotFoundException("Employee is Not Found");
		         }
		         
		  
	}


	@Override
	public Employee getEmployeeByID(Integer id) {
		
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if(employeeOptional.isPresent()) {
		Employee employee =	employeeOptional.get();
		return employee;
		}else {
			throw new EmployeeNotFoundException("Employee is not found this id: "+id);
		}
		
		
	}


	@Override
	public EmployeeDto updateEmployeeByID(Integer id, EmployeeDto employeeDto) {
		
		           Optional<Employee>    employee  =   employeeRepository.findById(id);
		           
		           
		           if(employee.isPresent()) {
		        	   
		        	          Employee  employee2  =  employee.get();
		        	   
		        	   BeanUtils.copyProperties(employeeDto, employee2);		        	   
		               
		               Employee  updateemployee  =  employeeRepository.save(employee2);
		               
		               BeanUtils.copyProperties(employee2, updateemployee);
		             
		             return  employeeDto;
		               
		        	   
		           }else {
		        	   throw new EmployeeNotFoundException("Employee is not found this id: "+id);
		           }
		                       
		
		
		
	}


	@Override
	public String deleteEmployeeByid(Integer id) {
		
		            if(employeeRepository.existsById(id)) {
		
		                      employeeRepository.deleteById(id);
		                      
		                      return "Employee Deleted Sucessfully";
		            }else {
		            	throw new EmployeeNotFoundException("Employee is not Found at this ID : "+id);
		            }
	}


	@Override
	public List<Employee> EmployeeByfirstname(String firstname) {
	                      
		       List<Employee> employee = employeeRepository.findByFirstname(firstname);
		       
		       if(!employee.isEmpty()) {
		    	   return employee;
		       }else {
		    	   throw new EmployeeNotFoundException("Employee is Not found that username: "+firstname);
		       }
		       
		       
	}


	@Override
	public List<Employee> getEmployeeBydesignation(String designation) {
	List<Employee> employee	=  employeeRepository.findByDesignation(designation);
	
	        if(!employee.isEmpty()) {
	        	return employee;
	        }else {
	        	throw new EmployeeNotFoundException("Employee is not found this Designation "+designation);
	        }
	}


	@Override
	public List<Employee> getEmployeeByage(Integer age) {
	List<Employee> employees  =	employeeRepository.findByAge(age);
	if(! employees.isEmpty()) {
		return employees;
	}else {
		throw new EmployeeNotFoundException("Employee is Not found for this Age: "+age);
	}
	}


	@Override
	public List<Employee> getEmployeeByaddress(String address) {
		List<Employee> employees =  employeeRepository.findByAddress(address);
		if(employees.isEmpty()) {
			throw new EmployeeNotFoundException("Employee is not found at this address"+address);
		}else {
			return employees;
		}
	}


	@Override
	public List<Employee> getEmployeeBygender(String gender) {
		 List<Employee> employees =  employeeRepository.findByGender(gender);
		 
		 if(employees.isEmpty()) {
			 throw new EmployeeNotFoundException("Employee is not found ");
		 }else {
			 return employees;
		 }
	
	}


	@Override
	public List<Employee> getEmployeeBysalary(Double salary) {
	List<Employee> employees =	employeeRepository.findBySalary(salary);
	
	if(employees.isEmpty()) {
		throw new EmployeeNotFoundException("Employee is not found at this Salary: "+salary);
	}else {
		return employees;
	}
	}  
	
	
}
