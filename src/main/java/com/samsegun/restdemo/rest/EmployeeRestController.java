package com.samsegun.restdemo.rest;

import com.samsegun.restdemo.entity.Employee;
import com.samsegun.restdemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home() {

        return "welcome to employees api";
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> employees() {
        List<Employee> employees = employeeService.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employees);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> employee(@PathVariable Integer employeeId) {
        Employee employee = employeeService.findEmployee(employeeId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employee);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.save(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newEmployee);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.save(employee);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
        employeeService.deleteEmployee(employeeId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deleted Employee id: " + employeeId);
    }
}
