package com.sara.crud.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sara.crud.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	
	public List<EmployeeEntity> findByName(String name);

}
