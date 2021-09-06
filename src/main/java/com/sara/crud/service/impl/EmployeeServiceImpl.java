package com.sara.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.sara.crud.dto.EmployeeDto;
import com.sara.crud.entity.EmployeeEntity;
import com.sara.crud.respository.EmployeeRepository;
import com.sara.crud.service.EmployeeService;
import com.sara.crud.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto employee) {
		
		EmployeeDto dto = null;
		
		if(!ObjectUtils.isEmpty(employee)) {
			
			EmployeeEntity entity = employeeRepository.save(EmployeeUtil.convertDtoToEntity(employee));
			
			if(!ObjectUtils.isEmpty(entity)) {
				dto = EmployeeUtil.convertEntityToDto(entity);
			}
		}
		

		return dto;
	}

	@Override
	public List<EmployeeDto> addEmployees(List<EmployeeDto> dtoList) {
		
		List<EmployeeDto> dtoResponseList = null;
		
		if(!ObjectUtils.isEmpty(dtoList)) {
			
			List<EmployeeEntity> entityList = employeeRepository.saveAll(EmployeeUtil.convertDtoToEntity(dtoList));
			
			if(!ObjectUtils.isEmpty(entityList)) {
				
				dtoResponseList = EmployeeUtil.convertEntityToDto(entityList);
			}

		}

		return dtoResponseList;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List<EmployeeDto> dtoResponseList = null;
		
		List<EmployeeEntity> entityList = employeeRepository.findAll();
		
		if(!ObjectUtils.isEmpty(entityList)) {
			
			dtoResponseList = EmployeeUtil.convertEntityToDto(entityList);
		}
		return dtoResponseList;
	}

	@Override
	public List<EmployeeDto> getEmployeeByName(String name) {
		
		List<EmployeeDto> dtoResponseList = null;
		
		if(!ObjectUtils.isEmpty(name)) {
			
			List<EmployeeEntity> entityList = employeeRepository.findByName(name);
			
			if(!ObjectUtils.isEmpty(entityList)) {
				
				dtoResponseList = EmployeeUtil.convertEntityToDto(entityList);
			}
			
		}
		return dtoResponseList;
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		
		EmployeeDto dto = null;
		
		if(!ObjectUtils.isEmpty(id)) {
			
			Optional<EmployeeEntity> optionalEntity = employeeRepository.findById(id);
			
			if(optionalEntity.isPresent()) {
				
				EmployeeEntity entity = optionalEntity.get();
				
				if(!ObjectUtils.isEmpty(entity)) {
					
					dto = EmployeeUtil.convertEntityToDto(entity);
				}
			}
		}
		return dto;
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto) {
		
		EmployeeDto dtoResponse = null;
		
		if(!ObjectUtils.isEmpty(dto)) {
			
			EmployeeEntity entity = employeeRepository.save(EmployeeUtil.convertDtoToEntity(dto));
			
			if(!ObjectUtils.isEmpty(entity)) {
				dtoResponse = EmployeeUtil.convertEntityToDto(entity);
			}
		}
		

		return dtoResponse;
	}


	@Override
	public void deleteEmployeeById(Long id) {
		
		if(!ObjectUtils.isEmpty(id)) {
			
			employeeRepository.deleteById(id);

		}
		
	}

}
