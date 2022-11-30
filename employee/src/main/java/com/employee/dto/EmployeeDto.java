package com.employee.dto;

public class EmployeeDto {
	
	   private Integer id;
	   private String employeeName;
	   private String emailId;
	   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", employeeName=" + employeeName + ", emailId=" + emailId + "]";
	}
	
}
