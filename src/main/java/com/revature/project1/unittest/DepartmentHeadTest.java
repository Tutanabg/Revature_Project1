package com.revature.project1.unittest;


import com.revature.project1.models.DepartmentHead;
import com.revature.project1.repositories.DepartmentHeadRepo;
import com.revature.project1.repositories.DepartmentHeadRepoHBImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentHeadTest {
    DepartmentHeadRepo bc = new DepartmentHeadRepoHBImpl();
    DepartmentHead a = new DepartmentHead();
    DepartmentHead b = new DepartmentHead();


    @Test
    public void addDepartmentHead() {
        a.setDh_name("Employee");
        a = bc.addDepartmentHead(a);
        assertEquals("Employee", a.getDh_name());

    }

    @Test
    public void getDepartmentHead(){
        a.setDh_name("Employee");
        a = bc.addDepartmentHead(a);
        a = bc.getDepartmentHead(a.getId());
        assertEquals("Employee", a.getDh_name());
    }

    @Test
    public void updateDepartmentHead(){
        a.setDh_name("Employee");
        a = bc.addDepartmentHead(a);
        b.setDh_name("Employee1");
        a = bc.addDepartmentHead(b);
        b = bc.updateDepartmentHead(a);
        assertEquals("Employee1", a.getDh_name());

    }

    @Test
    public void deleteDepartmentHead(){
        a.setDh_name("Employee5");
        a = bc.addDepartmentHead(a);
        b = bc.deleteDepartmentHead(a.getId());
        assertEquals("", "");
    }
}
