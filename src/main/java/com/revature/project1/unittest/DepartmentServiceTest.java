package com.revature.project1.unittest;

import com.revature.project1.models.Department;
import com.revature.project1.models.DepartmentHead;
import com.revature.project1.repositories.DepartmentHeadRepo;
import com.revature.project1.repositories.DepartmentHeadRepoHBImpl;
import com.revature.project1.repositories.DepartmentRepo;
import com.revature.project1.repositories.DepartmentRepoHBImpl;
import com.revature.project1.services.DepartmentHeadService;
import com.revature.project1.services.DepartmentHeadServiceImpl;
import com.revature.project1.services.DepartmentService;
import com.revature.project1.services.DepartmentServiceImpl;
import org.junit.Test;

public class DepartmentServiceTest {
    DepartmentRepo bc = new DepartmentRepoHBImpl();
    DepartmentService a = new DepartmentServiceImpl(bc);
    DepartmentService b = new DepartmentServiceImpl(bc);

    DepartmentHeadRepo dc = new DepartmentHeadRepoHBImpl();
    DepartmentHeadService d = new DepartmentHeadServiceImpl(dc);
    DepartmentHeadService e = new DepartmentHeadServiceImpl(dc);


//    public void addDepartmentHead() {
//        DepartmentHead j = new DepartmentHead( "Paul");
//        d.addDepartmentHead(j);
//
//    }



    @Test
    public void addDepartment() {
        DepartmentHead j = new DepartmentHead( "Paul");
        d.addDepartmentHead(j);
        Department m = new Department( "Transport",j);
        a.addDepartment(m);

    }


    @Test
    public void getDepartment() {
        DepartmentHead j = new DepartmentHead( "Paul");
        d.addDepartmentHead(j);
        Department m = new Department( "Transport",j);
        a.addDepartment(m);
        a.getDepartment(m.getId());

    }

    @Test
    public void updateDepartment(){
        DepartmentHead j = new DepartmentHead( "Paul");
        d.addDepartmentHead(j);
        Department m = new Department( "Transport",j);
        a.addDepartment(m);
        Department n = new Department( "Accounting",j);
        b.addDepartment(n);
        a.updateDepartment(n);

    }

    @Test
    public void deleteDepartment(){
        DepartmentHead j = new DepartmentHead( "Paul");
        d.addDepartmentHead(j);
        Department m = new Department( "Accounting",j);
        a.addDepartment(m);
        a.deleteDepartment(m.getId());

    }
}
