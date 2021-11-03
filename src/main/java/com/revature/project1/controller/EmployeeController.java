package com.revature.project1.controller;

import com.google.gson.Gson;
import com.revature.project1.models.BCA;
import com.revature.project1.models.Employee;
import com.revature.project1.services.BCAService;
import com.revature.project1.services.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmployeeController {
    EmployeeService em;
    Gson gson = new Gson();

    public EmployeeController(EmployeeService em) {
        this.em = em;
    }

    //Add Employee
    public Handler addEmployee = (context) -> {
        Employee b = gson.fromJson(context.body(), Employee.class);
        b = em.addEmployee(b);
        populateResult(context, b);
    };



//    Get Employee

    public Handler getEmployee = (context) -> {
        String input = context.pathParam("id");
        int employeeId;

        try {
            employeeId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            employeeId = -1;
        }

        Employee cl = em.getEmployee(employeeId);

        if (cl != null) {
            context.result(gson.toJson(cl));

        } else {
            context.status(404);


        }
    };


//    Update Employee

    public Handler updateEmployee = (con) -> {
        int id = Integer.parseInt(con.pathParam("id"));
        Employee cl = gson.fromJson(con.body(), Employee.class);


        cl = em.updateEmployee(cl);
        con.result((cl != null) ? gson.toJson(cl) : "{}");

    };




//    Delete Employee


    public Handler deleteEmployee = (con) -> {
        int id1 = Integer.parseInt(con.pathParam("id"));
        Employee cl1 = em.deleteEmployee(id1);

        if (cl1 != null) {
            con.status(204);
        } else {
            con.status(404);
        }
    };






    private void populateResult(Context context, Employee a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }
}
