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
import jakarta.persistence.SequenceGenerator;
@Entity
public class Employee {
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employee_seq")
    @SequenceGenerator(name="employee_seq",sequenceName = "employee_seq",allocationSize = 1)
    private Long ID;

    private String emailId;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(name="project_employee",joinColumns=@JoinColumn(name="employee_id"),inverseJoinColumns=@JoinColumn(name="project_id"))
    private List<Project> theProject;

    

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    

    public Employee(String emailId, String firstName, String lastName) {
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(){}

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Project> getProjects() {
        return theProject;
    }

    public void setProjects(List<Project> theProject) {
        this.theProject = theProject;
    }

}
