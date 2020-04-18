package com.sanjay.hibernateCrud.controller;

import com.sanjay.hibernateCrud.model.Employee;
import com.sanjay.hibernateCrud.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public List<Employee> get(){
        return employeeService.get();
    }

    @PostMapping
    public void save(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable int id){
        return employeeService.get(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int id){
        employeeService.delete(id);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.update(employee);
    }
}
