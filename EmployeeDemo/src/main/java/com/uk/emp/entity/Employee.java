package com.uk.emp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;



@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String firstName;
	private String lastName;
	private int age;
	private String employeeGender;
	private String designation;
	private String emailId;
	private String experience;
	private String phoneNumber;
	private String location;
	private String status;
	private LocalDate joiningDate;

	public String getEmployeeGender() {
		return employeeGender;
	}

	public String getDesignation() {
		return designation;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getExperience() {
		return experience;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public String getStatus() {
		return status;
	}

	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

}
