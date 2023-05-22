package com.jrp.projectmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class helloController {

    @GetMapping("/live")
    public String hello(){
        return "homepage";
    }

}
