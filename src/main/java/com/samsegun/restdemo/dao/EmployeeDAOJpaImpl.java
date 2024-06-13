package com.samsegun.restdemo.dao;

import com.samsegun.restdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findEmployee(Integer id) {
        //try {
            Employee theEmployee = entityManager.find(Employee.class, id);
            if (theEmployee == null) {
                throw new EntityException("Employee not found with id: " + id, "NOT FOUND");
            }

            return theEmployee;
        /** }
        catch (IllegalArgumentException | MethodArgumentTypeMismatchException e) {
            throw new EntityException("Invalid id provided for finding Employee with id: " + id,
                    "INVALID ARGUMENTS");
        } */
    }

    @Override
    public Employee save(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);
        return newEmployee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null) {
            throw new EntityException("Employee not found with id: " + id, "NOT FOUND");
        }

        entityManager.remove(employee);
    }
}
