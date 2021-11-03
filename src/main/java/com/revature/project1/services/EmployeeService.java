package com.revature.project1.services;


import com.revature.project1.models.Employee;

public interface EmployeeService {
    public Employee addEmployee(Employee bca);
    public Employee getEmployee(int id);
    public Employee updateEmployee(Employee change);
    public Employee deleteEmployee(int id);
}
