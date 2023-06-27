package com.jrp.projectmanagement.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.projectmanagement.dto.employeeProject;
import com.jrp.projectmanagement.dto.stageCount;
import com.jrp.projectmanagement.repositories.employeeRepository;
import com.jrp.projectmanagement.repositories.projectRepository;



@Controller
public class helloController {

    @Autowired
    projectRepository proRepo;

    @Autowired
    employeeRepository empRepo;


    @GetMapping("/live")
    public String hello(Model model) throws JsonProcessingException{
        List<stageCount> projects = proRepo.stageCnt();

        Map<String,Object> map = new HashMap<>();

        model.addAttribute("projects", projects);

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
