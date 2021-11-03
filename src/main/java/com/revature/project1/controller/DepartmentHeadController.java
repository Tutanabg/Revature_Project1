package com.revature.project1.controller;

import com.google.gson.Gson;
import com.revature.project1.models.BCA;
import com.revature.project1.models.DepartmentHead;
import com.revature.project1.services.BCAService;
import com.revature.project1.services.DepartmentHeadService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DepartmentHeadController {
    DepartmentHeadService dh;
    Gson gson = new Gson();

    public DepartmentHeadController(DepartmentHeadService dh) {
        this.dh = dh;
    }

    //Add DepartmentHead
    public Handler addDepartmentHead = (context) -> {
        DepartmentHead b = gson.fromJson(context.body(), DepartmentHead.class);
        b = dh.addDepartmentHead(b);
        populateResult(context, b);
    };



//    Get DepartmentHead

    public Handler getDepartmentHead = (context) -> {
        String input = context.pathParam("id");
        int departmentheadId;

        try {
            departmentheadId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            departmentheadId = -1;
        }

        DepartmentHead dl = dh.getDepartmentHead(departmentheadId);

        if (dl != null) {
            context.result(gson.toJson(dl));

        } else {
            context.status(404);


        }
    };


//    Update DepartmentHead

    public Handler updateDepartmentHead = (con) -> {
        int id = Integer.parseInt(con.pathParam("id"));
        DepartmentHead cl = gson.fromJson(con.body(), DepartmentHead.class);


        cl = dh.updateDepartmentHead(cl);
        con.result((cl != null) ? gson.toJson(cl) : "{}");

    };




//    Delete DepartmentHead


    public Handler deleteDepartmentHead = (con) -> {
        int id1 = Integer.parseInt(con.pathParam("id"));
        DepartmentHead cl1 = dh.deleteDepartmentHead(id1);

        if (cl1 != null) {
            con.status(204);
        } else {
            con.status(404);
        }
    };






    private void populateResult(Context context, DepartmentHead a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }
}
