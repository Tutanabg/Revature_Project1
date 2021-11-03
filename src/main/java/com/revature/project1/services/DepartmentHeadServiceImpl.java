package com.revature.project1.services;


import com.revature.project1.models.DepartmentHead;
import com.revature.project1.repositories.DepartmentHeadRepo;

public class DepartmentHeadServiceImpl implements DepartmentHeadService{

    DepartmentHeadRepo dh;

    public DepartmentHeadServiceImpl(DepartmentHeadRepo dh) {

        this.dh = dh;
    }



    @Override
    public DepartmentHead addDepartmentHead(DepartmentHead d) {
        return dh.addDepartmentHead(d);
    }

    @Override
    public DepartmentHead getDepartmentHead(int id) {
        return dh.getDepartmentHead(id);
    }

    @Override
    public DepartmentHead updateDepartmentHead(DepartmentHead change) {
        return dh.updateDepartmentHead(change);
    }

    @Override
    public DepartmentHead deleteDepartmentHead(int id) {
        return dh.deleteDepartmentHead(id);
    }
}
