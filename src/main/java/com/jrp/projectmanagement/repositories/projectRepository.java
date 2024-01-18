package com.jrp.projectmanagement.repositories;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jrp.projectmanagement.dto.stageCount;
import com.jrp.projectmanagement.dto.timeChartData;
import com.jrp.projectmanagement.entities.Project;

@ComponentScan
public interface projectRepository extends PagingAndSortingRepository<Project,Long>, CrudRepository<Project,Long>{

    @Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as val from Project group by stage")
    public List<stageCount> stageCnt(); 

    @Query(nativeQuery = true,value="Select name as name, project.start_date as startDate, project.end_date as endDate from Project")
    public List<timeChartData> getTimeData();
}
