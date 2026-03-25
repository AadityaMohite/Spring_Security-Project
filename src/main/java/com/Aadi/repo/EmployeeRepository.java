package com.Aadi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aadi.entity.Employee;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByFirstname(String firstname);
	
	List<Employee> findByDesignation(String designation);
	
	List<Employee> findByAge(Integer age);
	
	List<Employee> findByAddress(String address);
	
	List<Employee> findByGender(String gender);
	
	List<Employee> findBySalary(Double salary);
}
