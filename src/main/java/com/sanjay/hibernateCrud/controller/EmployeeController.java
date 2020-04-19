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

    /**
     * This method is used to get all the employees from the tbl_employee table.
     * @return list of employee
     */
    @GetMapping
    public List<Employee> get() {
        return employeeService.get();
    }

    /**
     * The method is used to save the employee in tbl_employee table.
     * @param employee This is incoming employee details which need to be saved in tbl_employee table
     */
    @PostMapping
    public void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    /**
     * The method is used to get the employee based on the employee id.
     * @param id This is incoming employee id
     * @return Employee returns the employee details
     * @throws ResourceNotFoundException throws not found exception for not existing employee
     */
    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) throws ResourceNotFoundException {
        Employee employee = employeeService.get(id);
        if (null == employee)
            throw new ResourceNotFoundException("The employee not found for this id:: " + id);

        return ResponseEntity.ok().body(employee);
    }

    /**
     * This method is used to delete the employee from tbl_employee table.
     * @param id incoming id to be deleted.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
    }

    /**
     * This method is used to update the existing employee.
     * @param employee Employee coming in from user
     */
    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.update(employee);
    }
}
