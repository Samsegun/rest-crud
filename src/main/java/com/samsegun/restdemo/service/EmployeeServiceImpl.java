package com.samsegun.restdemo.service;

import com.samsegun.restdemo.dao.EmployeeRepository;
import com.samsegun.restdemo.dao.EntityException;
import com.samsegun.restdemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployee(Integer id) {
        return checkForEmployee(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = checkForEmployee(id);
        employeeRepository.deleteById(employee.getId());
    }

    private Employee checkForEmployee(Integer id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new EntityException("Employee not found with id: " + id, "NOT FOUND");
        }

        return theEmployee;
    }
}
