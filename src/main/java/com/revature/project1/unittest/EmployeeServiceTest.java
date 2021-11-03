package com.revature.project1.unittest;

import com.revature.project1.models.*;
import com.revature.project1.repositories.*;
import com.revature.project1.services.*;
import org.junit.Test;

public class EmployeeServiceTest {
    EmployeeRepo bc = new EmployeeRepoHBImpl();
    EmployeeService a = new EmployeeServiceImpl(bc);
    EmployeeService b = new EmployeeServiceImpl(bc);

    DepartmentRepo dc = new DepartmentRepoHBImpl();
    DepartmentService e = new DepartmentServiceImpl(dc);


    GradesRepo ec = new GradesRepoHBImpl();
    GradesService f = new GradesServiceImpl(ec);



    SupervisorRepo fc = new SupervisorRepoHBImpl();
    SupervisorService h = new SupervisorServiceImpl(fc);

    DepartmentHeadRepo ddc = new DepartmentHeadRepoHBImpl();
    DepartmentHeadService dd = new DepartmentHeadServiceImpl(ddc);


    @Test
    public void addEmployee() {
        DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "Paul");
        h.addSupervisor(o);

        Employee m = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(m);

    }


    @Test
    public void getEmployee() {
        DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "Paul");
        h.addSupervisor(o);

        Employee m = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(m);
        a.getEmployee(m.getId());

    }

    @Test
    public void updateEmployee(){
        DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "Paul");
        h.addSupervisor(o);

        Employee m = new Employee( "Employee","city","user","password",o,"title",n,p,"email");
        a.addEmployee(m);
        Employee nn = new Employee( "Employee1","city","user","password",o,"title",n,p,"email");
        b.addEmployee(nn);
        a.updateEmployee(nn);

    }

    @Test
    public void deleteEmployee(){
        DepartmentHead z = new DepartmentHead( "Paul");
        dd.addDepartmentHead(z);

        Department p = new Department( "Transport",z);
        e.addDepartment(p);

        Grades n = new Grades( "pass","pass");
        f.addGrades(n);

        Supervisor o = new Supervisor( "Paul");
        h.addSupervisor(o);

        Employee m = new Employee( "Employee1","city","user","password",o,"title",n,p,"email");
        a.addEmployee(m);
        a.deleteEmployee(m.getId());

    }
}
