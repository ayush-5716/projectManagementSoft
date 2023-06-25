package com.jrp.projectmanagement.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    private String name;
    private String stage;
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(name="project_employee",joinColumns=@JoinColumn(name="project_id"),inverseJoinColumns=@JoinColumn(name="employee_id"))
    private List<Employee> emps;

    public List<Employee> getEmps() {
        return emps;
    }


    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }


    public Project(){}

    
    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
