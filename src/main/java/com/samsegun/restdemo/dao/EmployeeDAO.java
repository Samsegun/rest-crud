package com.samsegun.restdemo.dao;

import com.samsegun.restdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
