package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;
import com.employee.exception.EmployeeException;

public interface EmployeeService {
	public EmployeeDto getById(Integer id)throws EmployeeException;
	public List<EmployeeDto> getEmpList()throws EmployeeException;
	
	public String updateEmp(Integer id, EmployeeDto dto)throws EmployeeException;
	public String deleteById(Integer id)throws  EmployeeException;
	public String addEmp(EmployeeDto dto) throws EmployeeException;

}
