package com.sanjay.hibernateCrud.dao;

import com.sanjay.hibernateCrud.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate namedParameterJdbcTemplate;

    /**
     * This method is used to get all the employees from
     * tbl_employee table.
     *
     * @return List of Employee
     */
    @Transactional
    @Override
    public List<Employee> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }

    /**
     * This method is used to get the employee based upon the employee id
     *
     * @param id employee id
     * @return Employee Object
     */
    @Transactional
    @Override
    public Employee get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, id);
        return employee;
    }

    /**
     * This method is used to save the employee in tbl_employee table.
     *
     * @param employee
     */
    @Transactional
    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    /**
     * This method is used to delete the give employee id
     *
     * @param id
     */
    @Transactional
    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, id);
        currentSession.delete(employee);
    }

    /**
     * This method is used to update the existing employee.
     *
     * @param employee
     */
    @Transactional
    @Override
    public void update(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    /**
     * This method is used to demonstrate the capability of jdbctemplate to execute the query
     * @return returns the number of employee count
     */
    @Override
    public int getEmployeeCount() {

        int count = namedParameterJdbcTemplate.queryForObject("SELECT COUNT(*) FROM tbl_employee",Integer.class);
        return count;
    }
}
