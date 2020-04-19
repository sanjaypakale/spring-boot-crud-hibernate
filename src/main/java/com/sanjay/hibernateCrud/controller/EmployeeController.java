package com.sanjay.hibernateCrud.controller;

import com.sanjay.hibernateCrud.exception.ResourceNotFoundException;
import com.sanjay.hibernateCrud.model.Employee;
import com.sanjay.hibernateCrud.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public List<Employee> get() {
        return employeeService.get();
    }

    @PostMapping
    public void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) throws ResourceNotFoundException {
        Employee employee = employeeService.get(id);
        if (null == employee)
            throw new ResourceNotFoundException("The employee not found for this id:: " + id);

        return ResponseEntity.ok().body(employee);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.update(employee);
    }
}
