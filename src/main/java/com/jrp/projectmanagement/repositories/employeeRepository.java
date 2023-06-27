package com.jrp.projectmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.projectmanagement.dto.employeeProject;
import com.jrp.projectmanagement.entities.Employee;

public interface employeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll(); 
    
    @Query(nativeQuery= true, value = "SELECT e.first_name as firstName, e.last_name as lastName,COUNT(pe.employee_id) as projectCount " + //
            "FROM employee e left join project_employee pe ON pe.employee_id = e.id " + //
            "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
    public List<employeeProject> employeeProjects();
}
