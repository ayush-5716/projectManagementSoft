package com.jrp.projectmanagement.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.projectmanagement.entities.Employee;
import com.jrp.projectmanagement.repositories.employeeRepository;




@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiControlller {
    
    @Autowired
    employeeRepository empRepo;

    @GetMapping
    public Iterable<Employee> getEmployees(){
        return empRepo.findAll();
    }



    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody @Validated Employee employee) {
        //TODO: process POST request
        return empRepo.save(employee);
        
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody Employee employee){
        return empRepo.save(employee);
    }
    
    @PatchMapping(path="/{id}",consumes = "application/json")
    public Employee partialUpdate(@PathVariable("id") long id, @RequestBody Employee patchEmployee){
        Employee emp = empRepo.findById(id).get();
        if(patchEmployee.getEmailId() != null){
            emp.setEmailId(patchEmployee.getEmailId());
        }
        if(patchEmployee.getFirstName() != null){
            emp.setFirstName(patchEmployee.getFirstName());
        }
        if(patchEmployee.getLastName() != null){
            emp.setLastName(patchEmployee.getLastName());
        }

        return empRepo.save(emp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        empRepo.deleteById(id);
    }

    @GetMapping(params={"page","size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> findPaginatedEmployee(@RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageAndSize = PageRequest.of(page,size);

        return empRepo.findAll(pageAndSize);
    }

    

    

    


}
