package com.jrp.projectmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.projectmanagement.dto.stageCount;
import com.jrp.projectmanagement.entities.Project;

public interface projectRepository extends CrudRepository<Project,Long>{
    @Override
    public List<Project> findAll();

    @Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as val from Project group by stage")
    public List<stageCount> stageCnt(); 
}
