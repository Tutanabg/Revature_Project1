package com.revature.project1.services;

import com.revature.project1.models.Department;

public interface DepartmentService {
    public Department addDepartment(Department a);
    public Department getDepartment(int id);
    public Department updateDepartment(Department change);
    public Department deleteDepartment(int id);

}
