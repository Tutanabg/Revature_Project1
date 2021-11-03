package com.revature.project1.services;


import com.revature.project1.models.Employee;
import com.revature.project1.repositories.EmployeeRepo;

public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepo e;

    public EmployeeServiceImpl(EmployeeRepo e) {

        this.e = e;
    }
    @Override
    public Employee addEmployee(Employee em) {
        return e.addEmployee(em);
    }

    @Override
    public Employee getEmployee(int id) {
        return e.getEmployee(id);
    }

    @Override
    public Employee updateEmployee(Employee change) {
        return e.updateEmployee(change);
    }

    @Override
    public Employee deleteEmployee(int id) {
        return e.deleteEmployee(id);
    }
}
