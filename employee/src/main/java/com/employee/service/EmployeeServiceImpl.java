package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;
import com.employee.exception.EmployeeException;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository repository;
	@Autowired
	Environment environment;
	
	ModelMapper mapper =new ModelMapper();

	@Override
	public EmployeeDto getById(Integer id) throws EmployeeException {
		Optional<EmployeeEntity> entity=repository.findById(id);
		EmployeeEntity opj=	entity.orElseThrow(()->new EmployeeException(environment.getProperty("service.EMPLOYEEID_NOT_FOUND")));
		EmployeeDto dto=mapper.map(opj, EmployeeDto.class);
		return dto;
	}

	@Override
	public List<EmployeeDto> getEmpList() throws EmployeeException {
		List<EmployeeEntity> entity=repository.findAll();
		if(entity.isEmpty()) {
			throw new EmployeeException(environment.getProperty("service.EMPLOYEE_NOT_FOUND"));
		}
		List<EmployeeDto> list =new ArrayList<>();
		for(EmployeeEntity opj:entity) {
			EmployeeDto dto=mapper.map(opj, EmployeeDto.class);
			list.add(dto);
		}
		
		return list;
	}

	@Override
	public String addEmp(EmployeeDto dto) throws EmployeeException {
		EmployeeEntity employeeEntity=this.dtoToentity(dto);
		repository.save(employeeEntity);
		return environment.getProperty("API.ADD_SUCCESS");
	}

	@Override
	public String updateEmp(Integer id, EmployeeDto dto) throws EmployeeException {
		Optional<EmployeeEntity> optional=repository.findById(id);
		EmployeeEntity employeeEntity=optional.orElseThrow(()->new EmployeeException(environment.getProperty("service.EMPLOYEEID_NOT_FOUND")));
	
		employeeEntity.setEmailId(dto.getEmailId());
		employeeEntity.setEmployeeName(dto.getEmployeeName());
		employeeEntity.setEmailId(dto.getEmailId());
		repository.save(employeeEntity);
		return environment.getProperty("API.UPDATE_SUCCESS");
	}

	@Override
	public String deleteById(Integer id) throws EmployeeException {
		Optional<EmployeeEntity> employeeEntity=repository.findById(id);
		EmployeeEntity employee=employeeEntity.orElseThrow(()->new EmployeeException(environment.getProperty("service.EMPLOYEEID_NOT_FOUND")));
		repository.delete(employee);
		return environment.getProperty("API.DELETE_SUCCESS");
	}

	
	
	
	private EmployeeEntity dtoToentity(EmployeeDto dto) {
		EmployeeEntity entity=mapper.map(dto, EmployeeEntity.class);
		return entity;
		
	}

}
