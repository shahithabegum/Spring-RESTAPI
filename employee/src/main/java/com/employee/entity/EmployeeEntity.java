package com.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table")
public class EmployeeEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(name = "employee_name")
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
	return "EmployeeEntity [id=" + id + ", employeeName=" + employeeName + ", emailId=" + emailId + "]";
}
   
}
