package com.jrp.projectmanagement.controllers;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;
import com.jrp.projectmanagement.dto.employeeProject;
import com.jrp.projectmanagement.entities.Employee;
import com.jrp.projectmanagement.repositories.employeeRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/employees")
public class employeeController {

    @Autowired
    employeeRepository empRepo;

    @GetMapping("/")
    public String empHome(Model model){
        List<Employee> employees =  empRepo.findAll();
        model.addAttribute("employees", employees);
        return "employee/employee.html";
    }
    //be ok with yourself this is emp repo branch edited again
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

    @GetMapping("/update")
    public String updateEmployee(Model model,@RequestParam("id") long id){
        Employee emp = empRepo.findByID(id);
        model.addAttribute("aEmployee", emp);
        return "employee/update-employee";
    }

    @PostMapping("/updateEnd")
    public String updatePost(Employee employee,Model model){
        empRepo.save(employee);
        return "redirect:/employees/";
    }

    @GetMapping("/delete")
    public String deleteEmp(@RequestParam("id") long id) {

        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/apiemployees/" + id))
				.method("DELETE", HttpRequest.BodyPublishers.noBody())
				.build();

                try {
                    HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        return "redirect:/employees/";
    }
    
    

    
}
