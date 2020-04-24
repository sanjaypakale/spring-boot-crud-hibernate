package com.sanjay.hibernateCrud.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sanjay.hibernateCrud.model.Employee;

@JsonDeserialize(builder = com.sanjay.hibernateCrud.dto.EmployeeDto.class)
public class EmployeeDto {
    private Employee employee;

    public EmployeeDto() {
    }

    public EmployeeDto(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
