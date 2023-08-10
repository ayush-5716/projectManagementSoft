package com.jrp.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.projectmanagement.dto.stageCount;
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
    public String proHome(Model model) throws JsonProcessingException{
        List<stageCount> projects = proRepo.stageCnt();
        model.addAttribute("projects", projects);

        List<stageCount> stgCnt = proRepo.stageCnt();
        //converting object into json
        ObjectMapper objMapper = new ObjectMapper();
        String jsonString = objMapper.writeValueAsString(stgCnt);

        model.addAttribute("projectStageCnt", jsonString);
        
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
        System.out.println(project.getName());

        return "redirect:/projects/new-project";
    }
}
