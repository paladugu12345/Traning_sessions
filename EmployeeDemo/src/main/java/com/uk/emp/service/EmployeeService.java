package com.uk.emp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.uk.emp.dto.FetchEmployeeResponseDto;
import com.uk.emp.dto.UpdateRequestDto;
import com.uk.emp.entity.Employee;

public interface EmployeeService {
	public List<Employee> fetchEmployee() ;
	public Employee findByEmpId(Long empId);
	public String addEmployee(Employee employee) ;
	public String removeEmployee(Long employeeCode);
	public String updateEmployee(UpdateRequestDto updateRequestDto);
	public List<Employee> findByFirstName(String firstname);
	public List<Employee> findByLastName(String lastName);
	public List<Employee> findByLastNameContains(String lastName);
	public List<Employee> findByFirstNameAndLastName(String string, String lastName);
	public List<Employee> findByFirstNameOrLastName(String string, String lastName);
	public List<Employee> findByAge(int age);
	public List<Employee> findByAgeGreater(int age);
	public List<Employee> getAllEmployees(int pageNumber, int pageSize);
	public List<FetchEmployeeResponseDto> fetchEmployeeWithJoiningDate(int pageNumber, int pageSize, LocalDate joiningdate);
	public List<Employee> findByAgeOrderByFirstNameDesc(int age);
	public List<Employee> findByJoiningDateBetween(LocalDate fromDate, LocalDate toDate);




}
