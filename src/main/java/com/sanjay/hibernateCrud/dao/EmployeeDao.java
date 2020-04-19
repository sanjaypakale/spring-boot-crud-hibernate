package com.sanjay.hibernateCrud.dao;

import com.sanjay.hibernateCrud.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> get();

    Employee get(int id);

    void save(Employee employee);

    void delete(int id);

    void update(Employee employee);

    int getEmployeeCount();
}
