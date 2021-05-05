package com.uk.emp.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uk.emp.dto.FetchEmployeeResponseDto;
import com.uk.emp.dto.UpdateRequestDto;
import com.uk.emp.entity.Employee;
import com.uk.emp.repository.EmployeeRepository;
import com.uk.emp.service.EmployeeService;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Service

public class EmployeeServiceImpl  implements EmployeeService{
	
	@Autowired
	public EmployeeRepository employeeRepository;

	 public List<Employee> fetchEmployee() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee findByEmpId(Long empId) {
		return employeeRepository.findByEmpId(empId);

	}

	public String addEmployee(Employee employee) {	
		employeeRepository.save(employee);
		return "saved employee";
	}

	
		@Override
		public String removeEmployee(Long employeeCode) {
			Optional<Employee> employeeRecord;
			employeeRecord= employeeRepository.findById(employeeCode);
			
			if (!employeeRecord.isPresent()) {
				throw new RuntimeException("Employee not found");
			}		
			Employee employee=employeeRecord.get();
			employeeRepository.deleteById(employee.getEmpId());
			return "deleted succesfull";
		}
		@Override
		public String updateEmployee(UpdateRequestDto updateRequestDto) {
			Optional<Employee> employeeRecord;
			employeeRecord = employeeRepository.findById(updateRequestDto.getEmpId());
			
			if (!employeeRecord.isPresent()) {
				throw new RuntimeException("Employee Id not found");
			}
			
			Employee employee = employeeRecord.get();
			employee.setDesignation(updateRequestDto.getDesignation());
			employee.setEmailId(updateRequestDto.getEmailId());
			employee.setEmpId(updateRequestDto.getEmpId());
			employee.setEmployeeGender(updateRequestDto.getEmployeeGender());
			employee.setFirstName(updateRequestDto.getFirstName());
			employee.setLastName(updateRequestDto.getLastName());
			employee.setAge(updateRequestDto.getAge());
			employee.setExperience(updateRequestDto.getExperience());
			employee.setLocation(updateRequestDto.getLocation());
			employee.setPhoneNumber(updateRequestDto.getPhoneNumber());
			employee.setStatus(updateRequestDto.getStatus());
			employeeRepository.save(employee);

			return "Updated succesfull";
		}

		@Override
		public List<Employee> findByLastName(String lastName) {
			// TODO Auto-generated method stub
			return employeeRepository.findByLastName(lastName);
		}


@Override
public List<Employee> findByFirstName(String firstName) {
	// TODO Auto-generated method stub
	return employeeRepository.findByFirstName(firstName);
}


@Override
public List<Employee> findByLastNameContains(String lastName) {
	// TODO Auto-generated method stub
	return employeeRepository.findByLastNameContaining(lastName);
}


@Override
public List<Employee> findByFirstNameAndLastName(String firstname, String lastName) {
	// TODO Auto-generated method stub
	return employeeRepository.findByFirstNameAndLastName(firstname,lastName);
}


@Override
public List<Employee> findByFirstNameOrLastName(String firstname, String lastName) {
	// TODO Auto-generated method stub
	return employeeRepository.findByFirstNameOrLastName(firstname, lastName);
}


@Override
public List<Employee> findByAge(int age) {
	// TODO Auto-generated method stub
	return employeeRepository.findByAgeLessThan(age);
}


@Override
public List<Employee> findByAgeGreater(int age) {
	// TODO Auto-generated method stub
	return employeeRepository.findByAgeGreaterThan(age);
}


@Override
public List<Employee> getAllEmployees(int pageNumber, int pageSize) {
	// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, "firstName").and(Sort.by(Direction.ASC, "lastName")));
		return employeeRepository.findAll(pageable).getContent();
	}

@Override
public List<FetchEmployeeResponseDto> fetchEmployeeWithJoiningDate(int pageNumber, int pageSize, LocalDate JoiningDate) {
	Page<Employee> employeeDetails;
	List<FetchEmployeeResponseDto> FetchEmployeeResponseDto = new ArrayList<>();
	Pageable pageable = PageRequest.of(pageNumber, pageSize);
	employeeDetails = employeeRepository.findByJoiningDate(pageable, JoiningDate);

	if (employeeDetails.isEmpty()) {
		throw new RuntimeException("No activities found for this date");
	}

	employeeDetails.stream().forEach(employeeDetl -> {
		FetchEmployeeResponseDto fetchActivityResponseDto = new FetchEmployeeResponseDto();
		BeanUtils.copyProperties(employeeDetl, fetchActivityResponseDto);
		FetchEmployeeResponseDto.add(fetchActivityResponseDto);
	});
	return FetchEmployeeResponseDto;
}


@Override
public List<Employee> findByAgeOrderByFirstNameDesc(int age) {
	// TODO Auto-generated method stub
	return employeeRepository.findByAgeOrderByFirstNameDesc(age);
}


@Override
public List<Employee> findByJoiningDateBetween(LocalDate fromDate, LocalDate toDate) {
	// TODO Auto-generated method stub
	return employeeRepository.findByJoiningDateBetween(fromDate,toDate);
}
}



