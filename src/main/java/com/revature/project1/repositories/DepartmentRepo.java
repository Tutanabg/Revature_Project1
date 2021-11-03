package com.revature.project1.repositories;

import com.revature.project1.models.Department;

public interface DepartmentRepo {
    public Department addDepartment(Department a);
    public Department getDepartment(int id);
    public Department updateDepartment(Department change);
    public Department deleteDepartment(int id);

}
