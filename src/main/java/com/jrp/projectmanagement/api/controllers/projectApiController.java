package com.jrp.projectmanagement.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jrp.projectmanagement.entities.Employee;
import com.jrp.projectmanagement.entities.Project;
import com.jrp.projectmanagement.repositories.projectRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/app-api/projects")
public class projectApiController {
    @Autowired
    projectRepository proRepo;

    @GetMapping
    public Iterable<Project> getProject(){
        return proRepo.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        proRepo.deleteById(id);
    }

    @PostMapping
    public Project postMethodName(@RequestBody Project project) {
        //TODO: process POST request
        
        return proRepo.save(project);
    }
    
}
