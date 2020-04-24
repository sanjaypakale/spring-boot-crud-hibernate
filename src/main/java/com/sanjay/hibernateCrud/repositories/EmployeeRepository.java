package com.sanjay.hibernateCrud.repositories;

import com.sanjay.hibernateCrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
