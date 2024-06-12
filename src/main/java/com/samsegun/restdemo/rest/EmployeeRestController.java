package com.samsegun.restdemo.rest;

import com.samsegun.restdemo.entity.Employee;
import com.samsegun.restdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home() {

        return "welcome to employees api";
    }

    @GetMapping("/employees")
    public List<Employee> employees() {
        List<Employee> employees = employeeService.findAll();

        return employees;
    }
}
