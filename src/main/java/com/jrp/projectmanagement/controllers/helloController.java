package com.jrp.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.projectmanagement.dto.employeeProject;
import com.jrp.projectmanagement.dto.stageCount;
import com.jrp.projectmanagement.repositories.employeeRepository;
import com.jrp.projectmanagement.repositories.projectRepository;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class helloController {

    @Value("${version}")
    String ver;

    @Autowired
    projectRepository proRepo;

    @Autowired
    employeeRepository empRepo;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/logout")
    public String logoutPage() {
        return "logout";
    }
    
    
    @GetMapping("/")
    public String hello(Model model) throws JsonProcessingException{
        List<stageCount> projects = proRepo.stageCnt();
        model.addAttribute("projects", projects);
        model.addAttribute("ver", ver);
        List<stageCount> stgCnt = proRepo.stageCnt();

        //converting object into json
        ObjectMapper objMapper = new ObjectMapper();
        String jsonString = objMapper.writeValueAsString(stgCnt);

        model.addAttribute("projectStageCnt", jsonString);

        List<employeeProject> employees = empRepo.employeeProjects();
        model.addAttribute("employees", employees);
        return "homepage";
    }

}
