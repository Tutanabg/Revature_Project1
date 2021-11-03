package com.revature.project1.unittest;

import com.revature.project1.models.Department;
import com.revature.project1.models.Request;
import com.revature.project1.repositories.*;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class RequestTest {
    RequestRepo bc = new RequestRepoHBImpl();
    Request a = new Request();
    Request b = new Request();

    BCARepo bca = new BCARepoHBImpl();
    EmployeeRepo emp = new EmployeeRepoHBImpl();
    EventsRepo evt = new EventsRepoHBImpl();
    GradesRepo grd = new GradesRepoHBImpl();


    @Test
    public void addRequest() {
        a.setEmployee_id(emp.getEmployee(1));
        a.setUrgency("urgent");
        a.setDate(123);
        a.setTime(456);
        a.setLocation("here");
        a.setEvent_type(evt.getEvents(1));
        a.setDescription("training");
        a.setEvent_start_date(1);
        a.setRequested_cost(200);
        a.setAttached_document("certificate");
        a.setGrading_format(grd.getGrades(2));
        a.setEvent_reimb_cost(0);
        a.setApproved_by_ds(true);
        a.setApproved_by_dh(true);
        a.setBca_id(bca.getBCA(1));
        a.setApproved_by_bca(true);
        a = bc.addRequest(a);
        assertEquals(123, a.getDate());


    }

    @Test
    public void getRequest(){
        a.setEmployee_id(emp.getEmployee(1));
        a.setUrgency("urgent");
        a.setDate(123);
        a.setTime(456);
        a.setLocation("here");
        a.setEvent_type(evt.getEvents(1));
        a.setDescription("training");
        a.setEvent_start_date(1);
        a.setRequested_cost(200);
        a.setAttached_document("certificate");
        a.setGrading_format(grd.getGrades(2));
        a.setEvent_reimb_cost(0);
        a.setApproved_by_ds(true);
        a.setApproved_by_dh(true);
        a.setBca_id(bca.getBCA(1));
        a.setApproved_by_bca(true);
        a = bc.addRequest(a);
        a = bc.getRequest(a.getId());
        assertEquals("here", a.getLocation());
    }

    @Test
    public void updateRequest(){
        a.setEmployee_id(emp.getEmployee(1));
        a.setUrgency("not urgent");
        a.setDate(123);
        a.setTime(456);
        a.setLocation("here");
        a.setEvent_type(evt.getEvents(1));
        a.setDescription("training");
        a.setEvent_start_date(1);
        a.setRequested_cost(200);
        a.setAttached_document("certificate");
        a.setGrading_format(grd.getGrades(2));
        a.setEvent_reimb_cost(0);
        a.setApproved_by_ds(true);
        a.setApproved_by_dh(true);
        a.setBca_id(bca.getBCA(1));
        a.setApproved_by_bca(true);
        a = bc.addRequest(a);
        b.setEmployee_id(emp.getEmployee(1));
        b.setUrgency("Urgent");
        b.setDate(123);
        b.setTime(456);
        b.setLocation("here");
        b.setEvent_type(evt.getEvents(1));
        b.setDescription("training");
        b.setEvent_start_date(1);
        b.setRequested_cost(200);
        b.setAttached_document("certificate");
        b.setGrading_format(grd.getGrades(2));
        b.setEvent_reimb_cost(0);
        b.setApproved_by_ds(true);
        b.setApproved_by_dh(true);
        b.setBca_id(bca.getBCA(1));
        b.setApproved_by_bca(true);
        a = bc.addRequest(b);
        b = bc.updateRequest(a);
        assertEquals("Urgent", a.getUrgency());

    }



    @Test
    public void deleteRequest(){
        a.setEmployee_id(emp.getEmployee(1));
        a.setUrgency("urgent");
        a.setDate(123);
        a.setTime(456);
        a.setLocation("here");
        a.setEvent_type(evt.getEvents(1));
        a.setDescription("training");
        a.setEvent_start_date(1);
        a.setRequested_cost(200);
        a.setAttached_document("certificate");
        a.setGrading_format(grd.getGrades(2));
        a.setEvent_reimb_cost(0);
        a.setApproved_by_ds(true);
        a.setApproved_by_dh(true);
        a.setBca_id(bca.getBCA(1));
        a.setApproved_by_bca(true);
        a = bc.addRequest(a);
        b = bc.deleteRequest(a.getId());
        assertEquals("", "");
    }
}
