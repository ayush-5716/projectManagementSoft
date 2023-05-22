package com.jrp.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.projectmanagement.entities.Project;
import com.jrp.projectmanagement.repositories.projectRepository;



@Controller
@RequestMapping("/projects")
public class projectController {
    
    @Autowired
    projectRepository proRepo;

    @GetMapping("/")
    public String proHome(Model model){
        return "project/project";
    }

    @GetMapping("/new-project")
    public String newEmp(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "project/new-project";
    }

    @PostMapping("/create")
    public String createProject(Project project,Model model){
        proRepo.save(project);
        return "redirect:/projects/new-project";
    }
}