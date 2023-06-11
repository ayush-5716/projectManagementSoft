package com.jrp.projectmanagement.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.projectmanagement.entities.Project;

public interface projectRepository extends CrudRepository<Project,Long>{
    @Override
    public List<Project> findAll();
}
