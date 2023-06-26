package com.jrp.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.projectmanagement.entities.Employee;
import com.jrp.projectmanagement.entities.Project;
import com.jrp.projectmanagement.repositories.employeeRepository;
import com.jrp.projectmanagement.repositories.projectRepository;



@Controller
@RequestMapping("/projects")
public class projectController {
    
    @Autowired
    projectRepository proRepo;

    @Autowired
    employeeRepository empRepo;

    @GetMapping("/")
    public String proHome(Model model){
        List<Project> projects  = proRepo.findAll();
        
        model.addAttribute("projects",projects);
        
        return "project/project";
    }

    @GetMapping("/new-project")
    public String newEmp(Model model){
        Project project = new Project();
        List<Employee> emps = empRepo.findAll();
        model.addAttribute("emps", emps);
        model.addAttribute("project", project);
        return "project/new-project";
    }

    @PostMapping("/create")
    public String createProject(Project project){
        proRepo.save(project);

        return "redirect:/projects/new-project";
    }
}
