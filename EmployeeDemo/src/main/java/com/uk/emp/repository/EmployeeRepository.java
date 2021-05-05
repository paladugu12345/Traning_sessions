package com.uk.emp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uk.emp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	Employee findByEmpId(Long empId);

	List<Employee> findByLastName(String lastName);

	List<Employee> findByFirstName(String firstName);

	List<Employee> findByLastNameContaining(String lastName);

	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	List<Employee> findByFirstNameOrLastName(String firstName, String lastName);

	List<Employee> findByAgeLessThan(int age);

	List<Employee> findByAgeGreaterThan(int age);
	
	Page<Employee> findByJoiningDate(Pageable pageable, LocalDate JoiningDate);

	List<Employee> findByAgeOrderByFirstNameDesc(int age);

	//List<Employee> findByStartDateBetween(LocalDate joiningDate, LocalDate joiningDate);

	List<Employee> findByJoiningDateBetween(LocalDate fromDate, LocalDate toDate);


	


 
}

