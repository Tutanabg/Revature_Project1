package com.revature.project1.unittest;

import com.revature.project1.models.Department;
import com.revature.project1.repositories.DepartmentRepo;
import com.revature.project1.repositories.DepartmentRepoHBImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentTest {
    DepartmentRepo bc = new DepartmentRepoHBImpl();
    Department a = new Department();
    Department b = new Department();


    @Test
    public void addDepartment() {
        a.setD_name("Employee");
        a = bc.addDepartment(a);
        assertEquals("Employee", a.getD_name());

    }

    @Test
    public void getDepartment(){
        a.setD_name("Employee");
        a = bc.addDepartment(a);
        a = bc.getDepartment(a.getId());
        assertEquals("Employee", a.getD_name());
    }

    @Test
    public void updateDepartment(){
        a.setD_name("Employee");
        a = bc.addDepartment(a);
        b.setD_name("Employee1");
        a = bc.addDepartment(b);
        b = bc.updateDepartment(a);
        assertEquals("Employee1", a.getD_name());

    }

    @Test
    public void deleteDepartment(){
        a.setD_name("Employee5");
        a = bc.addDepartment(a);
        b = bc.deleteDepartment(a.getId());
        assertEquals("", "");
    }
}
