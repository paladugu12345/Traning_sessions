package com.uk.emp.controler;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uk.emp.dto.FetchEmployeeResponseDto;
import com.uk.emp.dto.UpdateRequestDto;
import com.uk.emp.entity.Employee;
import com.uk.emp.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeControler {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/fetchAllemployee")
	public List<Employee> fetchEmployee() {
		
		return  employeeService.fetchEmployee();
	}
	
	@GetMapping("getEmployee/{empId)")
	public Employee getEmployeecode(@RequestParam  Long empId) {
		return employeeService.findByEmpId(empId);
	}
	
	
	@PostMapping("/addemployees")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee)throws Exception {
		
		return new ResponseEntity<String>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@DeleteMapping("/removeeployee")
	public ResponseEntity<String> removeEmployee(@RequestParam Long employeeCode) {

		return new ResponseEntity<String>(employeeService.removeEmployee(employeeCode), HttpStatus.ACCEPTED);

	}
	@PatchMapping("/updateemployee")
	public ResponseEntity<String> updateEmployee(@RequestBody UpdateRequestDto updateRequestDto) {

		return new ResponseEntity<String>(employeeService.updateEmployee(updateRequestDto), HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/getfristname")
	public List<Employee> getEmployeebyFirstname(@RequestParam  String firstname) {
		return   employeeService.findByFirstName(firstname);
	}
	
	@GetMapping("/getlastname")
	public List<Employee> getEmployeebyLastname(@RequestParam  String lastName) {
		return   employeeService.findByLastName(lastName);
	}
	
	@GetMapping("/getlastnamelike")
	public List<Employee> getEmployeebyLastnameContains(@RequestParam  String lastName) {
		return   employeeService.findByLastNameContains(lastName);
	}
	@GetMapping("/getfullname")
	public List<Employee> getEmployeebyFirstnameandLastName(@RequestParam  String firstname,@RequestParam  String lastName) {
		return   employeeService.findByFirstNameAndLastName(firstname,lastName);
	}
	
	@GetMapping("/getfirstnameorlastname")
	public List<Employee> getEmployeebyFirstnameOrLastName(@RequestParam  String firstname,@RequestParam  String lastName) {
		return   employeeService.findByFirstNameOrLastName(firstname,lastName);
	}
	
	@GetMapping("/getorderbyfirstname")
	public List<Employee> getEmployeebyAgeOrderbyFirstnameDesc(@RequestParam int age) {
		return   employeeService.findByAgeOrderByFirstNameDesc(age);
	}
	@GetMapping("/getAge")
	public List<Employee> getEmployeebyAge(@RequestParam  int age) {
		return   employeeService.findByAge(age);
	}
	@GetMapping("/getagegreater")
	public List<Employee> getEmployeebyAgeGreater(@RequestParam  int age) {
		return   employeeService.findByAgeGreater(age);
	}
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(@RequestParam int pageNumber, @RequestParam int pageSize){
		return employeeService.getAllEmployees(pageNumber, pageSize);
	}
	@GetMapping("/getactivitywithdate")
	public List<FetchEmployeeResponseDto> fetchEmployeeWithJoiningDate(@RequestParam int pageNumber,
			@RequestParam int pageSize, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate joiningdate) {
		return employeeService.fetchEmployeeWithJoiningDate(pageNumber, pageSize, joiningdate);
	}
	
	

	
}
