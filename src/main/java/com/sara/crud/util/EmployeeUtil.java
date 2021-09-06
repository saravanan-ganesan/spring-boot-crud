package com.sara.crud.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sara.crud.dto.EmployeeDto;
import com.sara.crud.entity.EmployeeEntity;

public class EmployeeUtil {

	public static EmployeeDto convertEntityToDto(EmployeeEntity entity) {
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(entity, EmployeeDto.class);
	}
	
	public static EmployeeEntity convertDtoToEntity(EmployeeDto dto) {
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(dto, EmployeeEntity.class);
	}
	
	public static List<EmployeeEntity> convertDtoToEntity(List<EmployeeDto> dtoList) {
		
		List<EmployeeEntity> entityList = new ArrayList<>();
		
		ModelMapper mapper = new ModelMapper();
		entityList = mapper.map(dtoList, new TypeToken<List<EmployeeEntity>>() {}.getType());
		
		return entityList;
	}
	
	public static List<EmployeeDto> convertEntityToDto(List<EmployeeEntity> entityList) {
		
		List<EmployeeDto> dtoList = new ArrayList<>();
		
		ModelMapper mapper = new ModelMapper();
		dtoList = mapper.map(entityList, new TypeToken<List<EmployeeDto>>() {}.getType());
		
		return dtoList;
	}
}
