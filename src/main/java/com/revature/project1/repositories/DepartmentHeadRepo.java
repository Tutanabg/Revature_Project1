package com.revature.project1.repositories;


import com.revature.project1.models.DepartmentHead;

public interface DepartmentHeadRepo {
    public DepartmentHead addDepartmentHead(DepartmentHead bca);
    public DepartmentHead getDepartmentHead(int id);
    public DepartmentHead updateDepartmentHead(DepartmentHead change);
    public DepartmentHead deleteDepartmentHead(int id);
}
