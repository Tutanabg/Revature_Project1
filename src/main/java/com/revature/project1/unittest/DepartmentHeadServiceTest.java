package com.revature.project1.unittest;


import com.revature.project1.models.DepartmentHead;
import com.revature.project1.repositories.DepartmentHeadRepo;
import com.revature.project1.repositories.DepartmentHeadRepoHBImpl;
import com.revature.project1.services.DepartmentHeadService;
import com.revature.project1.services.DepartmentHeadServiceImpl;
import org.junit.Test;

public class DepartmentHeadServiceTest {
    DepartmentHeadRepo bc = new DepartmentHeadRepoHBImpl();
    DepartmentHeadService a = new DepartmentHeadServiceImpl(bc);
    DepartmentHeadService b = new DepartmentHeadServiceImpl(bc);



    @Test
    public void addDepartmentHead() {
        DepartmentHead m = new DepartmentHead( "Paul");
        a.addDepartmentHead(m);

    }


    @Test
    public void getDepartmentHead() {
        DepartmentHead m = new DepartmentHead( "Paul");
        a.addDepartmentHead(m);
        a.getDepartmentHead(m.getId());

    }

    @Test
    public void updateDepartmentHead(){
        DepartmentHead m = new DepartmentHead( "Paul");
        a.addDepartmentHead(m);
        DepartmentHead n = new DepartmentHead( "Mike");
        b.addDepartmentHead(n);
        a.updateDepartmentHead(n);

    }

    @Test
    public void deleteDepartmentHead(){
        DepartmentHead m = new DepartmentHead( "Mike");
        a.addDepartmentHead(m);
        a.deleteDepartmentHead(m.getId());

    }
}
