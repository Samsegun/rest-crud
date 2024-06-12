package com.samsegun.restdemo.service;

import com.samsegun.restdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
