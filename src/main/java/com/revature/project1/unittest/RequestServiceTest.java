package com.revature.project1.unittest;

import com.revature.project1.models.*;
import com.revature.project1.repositories.*;
import com.revature.project1.services.*;
import org.junit.Test;

public class RequestServiceTest {

    RequestRepo rc = new RequestRepoHBImpl();
    RequestService ra = new RequestServiceImpl(rc);
    RequestService rb = new RequestServiceImpl(rc);


    EmployeeRepo bc = new EmployeeRepoHBImpl();
    EmployeeService a = new EmployeeServiceImpl(bc);


    DepartmentRepo dc = new DepartmentRepoHBImpl();
    DepartmentService e = new DepartmentServiceImpl(dc);


    GradesRepo ec = new GradesRepoHBImpl();
    GradesService f = new GradesServiceImpl(ec);


    BCARepo eec = new BCARepoHBImpl();
    BCAService ff = new BCAServiceImpl(eec);

    EventsRepo evt = new EventsRepoHBImpl();
    EventsService ev = new EventsServiceImpl(evt);

    SupervisorRepo fc = new SupervisorRepoHBImpl();
    SupervisorService h = new SupervisorServiceImpl(fc);

    DepartmentHeadRepo ddc = new DepartmentHeadRepoHBImpl();
    DepartmentHeadService dd = new DepartmentHeadServiceImpl(ddc);


    @Test
    public void addRequest() {
        DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        BCA zz = new BCA( "Mike");
        ff.addBCA(zz);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "John");
        h.addSupervisor(o);

        Events evt = new Events( "Training");
        ev.addEvents(evt);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Employee em = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(em);


        Request m = new Request( em,"urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,true,true,zz,true);
        ra.addRequest(m);

    }


    @Test
    public void getRequest() {
        DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        BCA zz = new BCA( "Mike");
        ff.addBCA(zz);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "John");
        h.addSupervisor(o);

        Events evt = new Events( "Training");
        ev.addEvents(evt);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Employee em = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(em);


        Request m = new Request( em,"urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,true,true,zz,true);
        ra.addRequest(m);
        ra.getRequest(m.getId());

    }

    @Test
    public void updateRequest(){
         DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        BCA zz = new BCA( "Mike");
        ff.addBCA(zz);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "John");
        h.addSupervisor(o);

        Events evt = new Events( "Training");
        ev.addEvents(evt);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Employee em = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(em);

        Request m = new Request( em,"urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,true,true,zz,true);
        ra.addRequest(m);

        Request nn = new Request( em,"not urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,true,true,zz,true);
        rb.addRequest(nn);
        ra.updateRequest(nn);

    }




    @Test
    public void additionalRequestInfo(){
         DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        BCA zz = new BCA( "Mike");
        ff.addBCA(zz);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "John");
        h.addSupervisor(o);

        Events evt = new Events( "Training");
        ev.addEvents(evt);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Employee em = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(em);

        Request m = new Request( em,"urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,true,true,zz,true);
        ra.addRequest(m);

        Request nn = new Request( em,"not urgent",123456789,123456,"office",evt,"training",1234567,500,"additional certificate",n,0,true,true,zz,true);
        rb.addRequest(nn);
        ra.updateRequest(nn);

    }





    @Test
    public void denyRequest(){
          DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        BCA zz = new BCA( "Mike");
        ff.addBCA(zz);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "John");
        h.addSupervisor(o);

        Events evt = new Events( "Training");
        ev.addEvents(evt);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Employee em = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(em);

        Request m = new Request( em,"urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,true,true,zz,true);
        ra.addRequest(m);

        Request nn = new Request( em,"not urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,false,false,zz,false);
        rb.addRequest(nn);
        ra.updateRequest(nn);

    }






    @Test
    public void calculateRequestCost(){
          DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        BCA zz = new BCA( "Mike");
        ff.addBCA(zz);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "John");
        h.addSupervisor(o);

        Events evt = new Events( "Training");
        ev.addEvents(evt);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Employee em = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(em);

        Request m = new Request( em,"urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,true,true,zz,true);
        ra.addRequest(m);

        Request nn = new Request( em,"not urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,200,true,true,zz,true);
        rb.addRequest(nn);
        ra.updateRequest(nn);

    }






    @Test
    public void approveRequest(){
          DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        BCA zz = new BCA( "Mike");
        ff.addBCA(zz);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "John");
        h.addSupervisor(o);

        Events evt = new Events( "Training");
        ev.addEvents(evt);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Employee em = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(em);

        Request m = new Request( em,"urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,false,false,zz,false);
        ra.addRequest(m);

        Request nn = new Request( em,"not urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,500,true,true,zz,true);
        rb.addRequest(nn);
        ra.updateRequest(nn);

    }






    @Test
    public void deleteRequest(){
        DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        BCA zz = new BCA( "Mike");
        ff.addBCA(zz);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "John");
        h.addSupervisor(o);

        Events evt = new Events( "Training");
        ev.addEvents(evt);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Employee em = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(em);


        Request m = new Request( em,"urgent",123456789,123456,"office",evt,"training",1234567,500,"certificate",n,0,true,true,zz,true);
        ra.addRequest(m);
        ra.deleteRequest(m.getId());

    }
}
