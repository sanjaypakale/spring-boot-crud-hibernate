package com.sanjay.hibernateCrud.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController implements ErrorController {

    private final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String home(){
        return " Hello from Employee Management API";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
