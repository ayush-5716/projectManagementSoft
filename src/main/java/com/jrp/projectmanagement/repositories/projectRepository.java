package com.jrp.projectmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jrp.projectmanagement.entities.Project;

public interface projectRepository extends CrudRepository<Project,Long>{
    
}
