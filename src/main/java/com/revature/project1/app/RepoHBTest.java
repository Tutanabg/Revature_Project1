package com.revature.project1.app;

import com.revature.project1.models.*;
import com.revature.project1.repositories.*;

import java.util.Date;

public class RepoHBTest {


    public static void main(String[] args) {

//        BCA Test
        BCARepo bc = new BCARepoHBImpl();
        BCA a = new BCA();
        BCA b = new BCA();
        a.setName("John Smith");
        a = bc.addBCA(a);
        System.out.println(a);
        a = bc.getBCA(a.getId());
        System.out.println(a);
        a.setName("Mike");
        b = bc.updateBCA(a);
        System.out.println(b);
//        b = bc.deleteBCA(b.getId());
//        System.out.println(b);


//        Department Head Test

        DepartmentHeadRepo deph = new DepartmentHeadRepoHBImpl();
        DepartmentHead dph = new DepartmentHead();
        DepartmentHead dph1 = new DepartmentHead();
        dph.setDh_name("John Smith");
        dph = deph.addDepartmentHead(dph);
        System.out.println(dph);
        dph = deph.getDepartmentHead(dph.getId());
        System.out.println(dph);
        dph.setDh_name("Mike");
        dph1 = deph.updateDepartmentHead(dph);
        System.out.println(dph1);
//        dph1 = deph.deleteDepartmentHead(dph1.getId());
//        System.out.println(dph1);


        //        Events Test

        EventsRepo evt = new EventsRepoHBImpl();
        Events ev = new Events();
        Events ev1 = new Events();
        ev.setEvents("Certification");
        ev = evt.addEvents(ev);
        System.out.println(ev);
        ev = evt.getEvents(ev.getId());
        System.out.println(ev);
        ev.setEvents("Training");
        ev1 = evt.updateEvents(ev);
        System.out.println(ev1);
//        ev1 = evt.deleteEvents(ev1.getId());
//        System.out.println(ev1);


        //        Grades Test

        GradesRepo grd = new GradesRepoHBImpl();
        Grades gr = new Grades();
        Grades gr1 = new Grades();
        gr.setPresentation("Yes");
        gr.setClass_grade("Pass");
        gr = grd.addGrades(gr);
        System.out.println(gr);
        gr = grd.getGrades(gr.getId());
        System.out.println(gr);
        gr.setPresentation("No");
        gr.setClass_grade("Fail");
        gr1 = grd.updateGrades(gr);
        System.out.println(gr1);
//        gr1 = grd.deleteGrades(gr1.getId());
//        System.out.println(gr1);





        //        Supervisor Test

        SupervisorRepo su = new SupervisorRepoHBImpl();
        Supervisor s = new Supervisor();
        Supervisor s1 = new Supervisor();
        s.setS_name("John Smith");

        s = su.addSupervisor(s);
        System.out.println(s);
        s = su.getSupervisor(s.getId());
        System.out.println(s);
        s.setS_name("Mike");
        s1 = su.updateSupervisor(s);
        System.out.println(s1);
//        s1 = su.deleteSupervisor(s1.getId());
//        System.out.println(s1);




//        Department Test

        DepartmentRepo dp = new DepartmentRepoHBImpl();
        Department dep = new Department();
        Department dep1 = new Department();
        dep.setD_head(dep.getD_head());
        dep.setD_name("Finance");
        dep1.setD_head(dep.getD_head());
        dep1.setD_name("Transport");
        dep = dp.addDepartment(dep);
        System.out.println(dep);
        dep = dp.getDepartment(dep.getId());
        System.out.println(dep);
        dep.setD_head(dep.getD_head());
        dep.setD_name("Transport");
        dep1 = dp.updateDepartment(dep);
        System.out.println(dep1);
//        dep1 = dp.deleteDepartment(dep1.getId());
//        System.out.println(dep1);


















//        Employee Test
        EmployeeRepo emp = new EmployeeRepoHBImpl();
        Employee em = new Employee();
        Employee em1 = new Employee();
        em.setE_name("John Smith");
        em.setE_username("user");
        em.setE_password("password");
        em.setE_address("home");
        em.setE_supervisor(su.getSupervisor(1));
        em.setE_title("title");
        em.setE_grade(grd.getGrades(1));
        em.setE_department(dp.getDepartment(1));
        em.setE_email("email");
        em = emp.addEmployee(em);
        System.out.println(em);
        em = emp.getEmployee(em.getId());
        System.out.println(em);
        em.setE_name("Mike");
        em1 = emp.updateEmployee(em);
        System.out.println(em1);
//        em1 = emp.deleteEmployee(em1.getId());
//        System.out.println(em1);



















//        Request Test
        RequestRepo req = new RequestRepoHBImpl();
        Request rq = new Request();
        Request rq1 = new Request();
        rq.setEmployee_id(emp.getEmployee(1));
        rq.setUrgency("user");
        rq.setDate(123456789123456L);
        rq.setTime(456232);
        Date d=new Date(rq.getDate());
        System.out.println(d);
        System.out.println(java.time.LocalDate.now());
        rq.setLocation("here");
        rq.setEvent_type(evt.getEvents(1));
        rq.setDescription("training");
        rq.setEvent_start_date(1);
        rq.setRequested_cost(200);
        rq.setAttached_document("password");
        rq.setGrading_format(grd.getGrades(2));
        rq.setEvent_reimb_cost(0);
        rq.setApproved_by_ds(true);
        rq.setApproved_by_dh(true);
//        rq.setBca_id(bc.getBCA(1));
        rq.setApproved_by_bca(true);

        rq = req.addRequest(rq);
        System.out.println(rq);
        rq = req.getRequest(rq.getId());
        System.out.println(rq);
        rq.setUrgency("urgent");
        rq1 = req.updateRequest(rq);
        System.out.println(rq1);
//        rq1 = req.deleteRequest(rq1.getId());
//        System.out.println(rq1);











    }
}
