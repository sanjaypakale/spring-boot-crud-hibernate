package com.sanjay.hibernateCrud.services;

import com.sanjay.hibernateCrud.dao.EmployeeDao;
import com.sanjay.hibernateCrud.dao.EmployeeDaoImp;
import com.sanjay.hibernateCrud.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeDao employeeDaoImp;

    @Transactional
    @Override
    public List<Employee> get() {
        return employeeDaoImp.get();
    }

    @Transactional
    @Override
    public Employee get(int id) {
        return employeeDaoImp.get(id);
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        employeeDaoImp.save(employee);
    }


    @Transactional
    @Override
    public void delete(int id) {
        employeeDaoImp.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDaoImp.update(employee);
    }
}
