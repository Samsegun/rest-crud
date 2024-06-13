package com.samsegun.restdemo.dao;

import com.samsegun.restdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findEmployee(Integer id);
    Employee save(Employee employee);
    void deleteEmployee(Integer id);
}
