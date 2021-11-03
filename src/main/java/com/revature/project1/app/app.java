package com.revature.project1.app;

import com.revature.project1.controller.*;
import com.revature.project1.repositories.*;
import com.revature.project1.services.*;
import com.revature.project1.util.HibernateUtil;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import jdk.nashorn.internal.ir.RuntimeNode;

public class app {
    public static void main(String[] args) {
//Javalin Object
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).start(7008);
        //Route/Endpoints .
        establishRoutes(app);
        addBCA(app);
        addDepartment(app);
        addDepartmentHead(app);
        addEmployee(app);
        addEvents(app);
        addGrades(app);
        addSupervisor(app);
        addRequest(app);
        addEmails(app);
        //Run Javalin
//        app.start(7003);
    }

    private static void establishRoutes(Javalin app) {

        //Establish a route to the Welcome page.
        app.get("/", (ctx) -> ctx.result("Welcome to the TRMS Application API"));

    }





    private static void addBCA(Javalin app) {


       BCARepo br = new BCARepoHBImpl();
       BCAService bs =  new BCAServiceImpl(br);
       BCAController bc = new BCAController(bs);

       app.post("/bca", bc.addBCA);
       app.get("/bca/:id", bc.getBCA);
       app.put("/bca/:id", bc.updateBCA);
       app.delete("/bca/:id", bc.deleteBCA);


        HibernateUtil.getSession();
    }


    private static void addDepartment(Javalin app) {


        DepartmentRepo dr = new DepartmentRepoHBImpl();
        DepartmentService ds =  new DepartmentServiceImpl(dr);
        DepartmentController dc = new DepartmentController(ds);

        app.post("/department", dc.addDepartment);
        app.get("/department/:id", dc.getDepartment);
        app.put("/department/:id", dc.updateDepartment);
        app.delete("/department/:id", dc.deleteDepartment);


        HibernateUtil.getSession();
    }


    private static void addDepartmentHead(Javalin app) {


        DepartmentHeadRepo dhr = new DepartmentHeadRepoHBImpl();
        DepartmentHeadService dhs =  new DepartmentHeadServiceImpl(dhr);
        DepartmentHeadController dhc = new DepartmentHeadController(dhs);

        app.post("/departmenthead", dhc.addDepartmentHead);
        app.get("/departmenthead/:id", dhc.getDepartmentHead);
        app.put("/departmenthead/:id", dhc.updateDepartmentHead);
        app.delete("/departmenthead/:id", dhc.deleteDepartmentHead);



        HibernateUtil.getSession();
    }


    private static void addEmployee(Javalin app) {


        EmployeeRepo er = new EmployeeRepoHBImpl();
        EmployeeService es =  new EmployeeServiceImpl(er);
        EmployeeController ec = new EmployeeController(es);

        app.post("/employee", ec.addEmployee);
        app.get("/employee/:id", ec.getEmployee);
        app.put("/employee/:id", ec.updateEmployee);
        app.delete("/employee/:id", ec.deleteEmployee);



        HibernateUtil.getSession();
    }



    private static void addEvents(Javalin app) {


        EventsRepo evr = new EventsRepoHBImpl();
        EventsService evs =  new EventsServiceImpl(evr);
        EventsController evc = new EventsController(evs);

        app.post("/events", evc.addEvents);
        app.get("/events/:id", evc.getEvents);
        app.put("/events/:id", evc.updateEvents);
        app.delete("/events/:id", evc.deleteEvents);



        HibernateUtil.getSession();
    }



    private static void addGrades(Javalin app) {


        GradesRepo gr = new GradesRepoHBImpl();
        GradesService gs =  new GradesServiceImpl(gr);
        GradesController gc = new GradesController(gs);

        app.post("/grades", gc.addGrades);
        app.get("/grades/:id", gc.getGrades);
        app.put("/grades/:id", gc.updateGrades);
        app.delete("/grades/:id", gc.deleteGrades);



        HibernateUtil.getSession();
    }



    private static void addSupervisor(Javalin app) {


        SupervisorRepo sr = new SupervisorRepoHBImpl();
        SupervisorService ss =  new SupervisorServiceImpl(sr);
        SupervisorController sc = new SupervisorController(ss);

        app.post("/supervisor", sc.addSupervisor);
        app.get("/supervisor/:id", sc.getSupervisor);
        app.put("/supervisor/:id", sc.updateSupervisor);
        app.delete("/supervisor/:id", sc.deleteSupervisor);



        HibernateUtil.getSession();
    }



    private static void addRequest(Javalin app) {


        RequestRepo rr = new RequestRepoHBImpl();
        RequestService rs =  new RequestServiceImpl(rr);
        RequestController rc = new RequestController(rs);

        app.post("/request", rc.addRequest);
        app.get("/request/:id", rc.getRequest);
        app.put("/request/:id", rc.updateRequest);
        app.delete("/request/:id/delete", rc.deleteRequest);
        app.get("/request", rc.getAllRequest);


        HibernateUtil.getSession();
    }

    private static void addEmails(Javalin app) {


        EmailsRepo br = new EmailsRepoHBImpl();
        EmailsService bs =  new EmailsServiceImpl(br);
        EmailsController bc = new EmailsController(bs);

        app.post("/emails", bc.addEmails);
        app.get("/emails/:id", bc.getEmails);



        HibernateUtil.getSession();
    }

}
