package com.revature.project1.services;

import com.revature.project1.models.Department;
import com.revature.project1.repositories.DepartmentRepo;


public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepo d;

    public DepartmentServiceImpl(DepartmentRepo d) {

        this.d = d;
    }


    @Override
    public Department addDepartment(Department a) {
        return d.addDepartment(a);
    }

    @Override
    public Department getDepartment(int id) {
        return d.getDepartment(id);
    }

    @Override
    public Department updateDepartment(Department change) {
        return d.updateDepartment(change);
    }

    @Override
    public Department deleteDepartment(int id) {
        return d.deleteDepartment(id);
    }
}

