package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;
import com.employee.exception.EmployeeException;
import com.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/get/{id}")
	public EmployeeDto getById(@PathVariable Integer id)throws  EmployeeException{
		return employeeService.getById(id);
	}
	
	@GetMapping("/getall")
		public List<EmployeeDto> getAll() throws EmployeeException{
			return employeeService.getEmpList();
		}
	@PostMapping("/add")
	public String add(@RequestBody EmployeeDto dto)throws EmployeeException{
		return employeeService.addEmp(dto);
	}
	@PutMapping("/update/{id}")
	public String Update(@RequestBody EmployeeDto dto,@PathVariable Integer id) throws EmployeeException {
		return employeeService.updateEmp(id, dto);
	}
	@DeleteMapping("/delete/{id}")	
	public String Delete(@PathVariable Integer id) throws EmployeeException {
		return employeeService.deleteById(id);
	}

	
	}


