package com.revature.project1.unittest;

import com.revature.project1.models.Supervisor;
import com.revature.project1.repositories.SupervisorRepo;
import com.revature.project1.repositories.SupervisorRepoHBImpl;
import com.revature.project1.services.SupervisorService;
import com.revature.project1.services.SupervisorServiceImpl;
import org.junit.Test;

public class SupervisorServiceTest {

    SupervisorRepo bc = new SupervisorRepoHBImpl();
    SupervisorService a = new SupervisorServiceImpl(bc);
    SupervisorService b = new SupervisorServiceImpl(bc);



    @Test
    public void addSupervisor() {
        Supervisor m = new Supervisor( "Employee");
        a.addSupervisor(m);

    }


    @Test
    public void getSupervisor() {
        Supervisor m = new Supervisor( "Employee");
        a.addSupervisor(m);
        a.getSupervisor(m.getId());

    }

    @Test
    public void updateSupervisor(){
        Supervisor m = new Supervisor( "Employee");
        a.addSupervisor(m);
        Supervisor n = new Supervisor( "Employee1");
        b.addSupervisor(n);
        a.updateSupervisor(n);

    }

    @Test
    public void deleteSupervisor(){
        Supervisor m = new Supervisor( "Employee");
        a.addSupervisor(m);
        a.deleteSupervisor(m.getId());

    }

}
