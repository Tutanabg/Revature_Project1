package com.revature.project1.unittest;

import com.revature.project1.models.Department;
import com.revature.project1.models.Supervisor;
import com.revature.project1.repositories.DepartmentRepo;
import com.revature.project1.repositories.DepartmentRepoHBImpl;
import com.revature.project1.repositories.SupervisorRepo;
import com.revature.project1.repositories.SupervisorRepoHBImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SupervisorTest {
    SupervisorRepo bc = new SupervisorRepoHBImpl();
    Supervisor a = new Supervisor();
    Supervisor b = new Supervisor();


    @Test
    public void addDepartment() {
        a.setS_name("Paul");
        a = bc.addSupervisor(a);
        assertEquals("Paul", a.getS_name());

    }

    @Test
    public void getDepartment(){
        a.setS_name("Paul");
        a = bc.addSupervisor(a);
        a = bc.getSupervisor(a.getId());
        assertEquals("Paul", a.getS_name());
    }

    @Test
    public void updateDepartment(){
        a.setS_name("Paul");
        a = bc.addSupervisor(a);
        b.setS_name("Mike");
        a = bc.addSupervisor(b);
        b = bc.updateSupervisor(a);
        assertEquals("Mike", a.getS_name());

    }

    @Test
    public void deleteDepartment(){
        a.setS_name("Mike");
        a = bc.addSupervisor(a);
        b = bc.deleteSupervisor(a.getId());
        assertEquals("", "");
    }
}
