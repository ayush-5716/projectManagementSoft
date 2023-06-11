package com.jrp.projectmanagement.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.projectmanagement.entities.Employee;

public interface employeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();
}
