package com.jrp.projectmanagement.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.jrp.projectmanagement.entities.Employee;
import com.jrp.projectmanagement.repositories.employeeRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Null;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String>{

    @Autowired
    employeeRepository empRepo;

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        // TODO Auto-generated method stub

        System.out.println("Entered validation");
        Employee emp =empRepo.findByEmailId(arg0);

        if (emp!=null)
            return false;
        else
            return true;
    }

}
