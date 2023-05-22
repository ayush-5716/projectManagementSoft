package com.jrp.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.projectmanagement.entities.Employee;
import com.jrp.projectmanagement.repositories.employeeRepository;

@Controller
@RequestMapping("/employees")
public class employeeController {
    @Autowired
    employeeRepository empRepo;

    @GetMapping("/")
    public String empHome(Model model){
        return "employee/employee.html";
    }
    //be ok with yourself this is emp repo branch
    @GetMapping("/new-employee")
    public String newEmp(Model model){
        Employee Empobj = new Employee();
        model.addAttribute("empObj",Empobj);
        return "employee/new-employee";
    }

    @PostMapping("/create")
    public String createEmp(Employee employee,Model model){
        empRepo.save(employee);
        return "redirect:/employees/new-employee";
    }
}
