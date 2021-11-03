package com.revature.project1.repositories;


import com.revature.project1.models.Employee;

public interface EmployeeRepo {
    public Employee addEmployee(Employee bca);
    public Employee getEmployee(int id);
    public Employee updateEmployee(Employee change);
    public Employee deleteEmployee(int id);
}
