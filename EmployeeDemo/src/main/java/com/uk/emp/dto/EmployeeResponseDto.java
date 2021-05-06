package com.uk.emp.dto;

public class EmployeeResponseDto {
	private String firstName;
	private long count;
	
	
	public EmployeeResponseDto(String firstName,long count)
	{
		this.firstName=firstName;
		this.count=count;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}


}
