package com.jrp.projectmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jrp.projectmanagement.entities.Employee;

public interface employeeRepository extends CrudRepository<Employee, Long> {
    
}
