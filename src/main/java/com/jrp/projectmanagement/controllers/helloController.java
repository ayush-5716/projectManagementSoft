package com.jrp.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.projectmanagement.entities.Employee;
import com.jrp.projectmanagement.entities.Project;
import com.jrp.projectmanagement.repositories.employeeRepository;
import com.jrp.projectmanagement.repositories.projectRepository;



@Controller
public class helloController {

    @Autowired
    projectRepository proRepo;

    @Autowired
    employeeRepository empRepo;


    @GetMapping("/live")
    public String hello(Model model){
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employees", employees);
        return "homepage";
    }

}
