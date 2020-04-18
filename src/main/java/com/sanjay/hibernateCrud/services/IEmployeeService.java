package com.sanjay.hibernateCrud.services;

import com.sanjay.hibernateCrud.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> get();
    Employee get(int id);
    void save(Employee employee);
    void delete(int id);
    void update(Employee employee);
}
