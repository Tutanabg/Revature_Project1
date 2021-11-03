package com.revature.project1.controller;

import com.google.gson.Gson;
import com.revature.project1.models.Department;
import com.revature.project1.services.DepartmentService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DepartmentController {
    DepartmentService dp;
    Gson gson = new Gson();

    public DepartmentController(DepartmentService dp) {
        this.dp = dp;
    }

//Add Department
    public Handler addDepartment = (context) -> {
    Department d = gson.fromJson(context.body(), Department.class);
        d = dp.addDepartment(d);
        populateResult(context, d);
    };



//    Get Department

    public Handler getDepartment = (context) -> {
        String input = context.pathParam("id");
        int departmentId;

        try {
            departmentId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            departmentId = -1;
        }

        Department cl = dp.getDepartment(departmentId);

        if (cl != null) {
            context.result(gson.toJson(cl));

        } else {
            context.status(404);


        }
    };


//    Update Department

    public Handler updateDepartment = (con) -> {
        int id = Integer.parseInt(con.pathParam("id"));
        Department cl = gson.fromJson(con.body(), Department.class);


        cl = dp.updateDepartment(cl);
        con.result((cl != null) ? gson.toJson(cl) : "{}");

    };




//    Delete Department


    public Handler deleteDepartment = (con) -> {
        int id1 = Integer.parseInt(con.pathParam("id"));
        Department cl1 = dp.deleteDepartment(id1);

        if (cl1 != null) {
            con.status(204);
        } else {
            con.status(404);
        }
    };






    private void populateResult(Context context, Department a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }

}
