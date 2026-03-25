package com.Aadi.ServiceImpl;

import java.util.List;
import java.util.Optional;

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
		
		Employee employee = new Employee();
		
		
		employee.setFirstname(employeeDto.getFirstname());
		employee.setLastname(employeeDto.getLastname());
		employee.setEmail(employeeDto.getEmail());
		employee.setMobileno(employeeDto.getMobileno());
		employee.setAddress(employeeDto.getAddress());
		employee.setAge(employeeDto.getAge());
		employee.setDep(employeeDto.getDep());
		employee.setDesignation(employeeDto.getDesignation());
		employee.setDoB(employeeDto.getDoB());
		employee.setEducationqualification(employeeDto.getEducationqualification());
		employee.setExperience(employeeDto.getExperience());
		employee.setSalary(employeeDto.getSalary());
		employee.setGender(employeeDto.getGender());
		employee.setIsMarried(employeeDto.getIsMarried());
        employee.setStatus(employeeDto.getStatus());
        employee.setStatus(employeeDto.getStatus());
        employee.setJoiningDate(employeeDto.getJoiningDate());
        
        
      Employee saveemployee   =   employeeRepository.save(employee);
		
      employeeDto.setFirstname(saveemployee.getFirstname());
		employeeDto.setLastname(saveemployee.getLastname());
		employeeDto.setEmail(saveemployee.getEmail());
		employeeDto.setMobileno(saveemployee.getMobileno());
		employeeDto.setAddress(saveemployee.getAddress());
		employeeDto.setAge(saveemployee.getAge());
		employeeDto.setDep(saveemployee.getDep());
		employeeDto.setDesignation(saveemployee.getDesignation());
		employeeDto.setDoB(saveemployee.getDoB());
		employeeDto.setEducationqualification(saveemployee.getEducationqualification());
		employeeDto.setExperience(saveemployee.getExperience());
		employeeDto.setSalary(saveemployee.getSalary());
		employeeDto.setGender(saveemployee.getGender());
		employeeDto.setIsMarried(saveemployee.getIsMarried());
      employeeDto.setStatus(saveemployee.getStatus());
      employeeDto.setStatus(saveemployee.getStatus());
      employeeDto.setJoiningDate(saveemployee.getJoiningDate());
		
		
		
		
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
		        	   
		        	   employee2.setFirstname(employeeDto.getFirstname());
		       		employee2.setLastname(employeeDto.getLastname());
		       		employee2.setEmail(employeeDto.getEmail());
		       		employee2.setMobileno(employeeDto.getMobileno());
		       		employee2.setAddress(employeeDto.getAddress());
		       		employee2.setAge(employeeDto.getAge());
		       		employee2.setDep(employeeDto.getDep());
		       		employee2.setDesignation(employeeDto.getDesignation());
		       		employee2.setDoB(employeeDto.getDoB());
		       		employee2.setEducationqualification(employeeDto.getEducationqualification());
		       		employee2.setExperience(employeeDto.getExperience());
		       		employee2.setSalary(employeeDto.getSalary());
		       		employee2.setGender(employeeDto.getGender());
		       		employee2.setIsMarried(employeeDto.getIsMarried());
		               employee2.setStatus(employeeDto.getStatus());
		               employee2.setStatus(employeeDto.getStatus());
		               employee2.setJoiningDate(employeeDto.getJoiningDate());
		        	   
		               
		               Employee  updateemployee  =  employeeRepository.save(employee2);
		               
		               employeeDto.setFirstname(updateemployee.getFirstname());
		       		employeeDto.setLastname(updateemployee.getLastname());
		       		employeeDto.setEmail(updateemployee.getEmail());
		       		employeeDto.setMobileno(updateemployee.getMobileno());
		       		employeeDto.setAddress(updateemployee.getAddress());
		       		employeeDto.setAge(updateemployee.getAge());
		       		employeeDto.setDep(updateemployee.getDep());
		       		employeeDto.setDesignation(updateemployee.getDesignation());
		       		employeeDto.setDoB(updateemployee.getDoB());
		       		employeeDto.setEducationqualification(updateemployee.getEducationqualification());
		       		employeeDto.setExperience(updateemployee.getExperience());
		       		employeeDto.setSalary(updateemployee.getSalary());
		       		employeeDto.setGender(updateemployee.getGender());
		       		employeeDto.setIsMarried(updateemployee.getIsMarried());
		             employeeDto.setStatus(updateemployee.getStatus());
		             employeeDto.setStatus(updateemployee.getStatus());
		             employeeDto.setJoiningDate(updateemployee.getJoiningDate());
		             
		             
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
