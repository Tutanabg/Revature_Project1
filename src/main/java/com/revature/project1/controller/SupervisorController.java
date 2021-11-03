package com.revature.project1.controller;

import com.google.gson.Gson;
import com.revature.project1.models.BCA;
import com.revature.project1.models.Supervisor;
import com.revature.project1.services.BCAService;
import com.revature.project1.services.SupervisorService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class SupervisorController {
    SupervisorService su;
    Gson gson = new Gson();

    public SupervisorController(SupervisorService su) {
        this.su = su;
    }

    //Add Supervisor
    public Handler addSupervisor = (context) -> {
        Supervisor b = gson.fromJson(context.body(), Supervisor.class);
        b = su.addSupervisor(b);
        populateResult(context, b);
    };



//    Get Supervisor

    public Handler getSupervisor = (context) -> {
        String input = context.pathParam("id");
        int supervisorId;

        try {
            supervisorId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            supervisorId = -1;
        }

        Supervisor cl = su.getSupervisor(supervisorId);

        if (cl != null) {
            context.result(gson.toJson(cl));

        } else {
            context.status(404);


        }
    };


//    Update Supervisor

    public Handler updateSupervisor = (con) -> {
        int id = Integer.parseInt(con.pathParam("id"));
        Supervisor cl = gson.fromJson(con.body(), Supervisor.class);


        cl = su.updateSupervisor(cl);
        con.result((cl != null) ? gson.toJson(cl) : "{}");

    };




//    Delete Supervisor


    public Handler deleteSupervisor = (con) -> {
        int id1 = Integer.parseInt(con.pathParam("id"));
        Supervisor cl1 = su.deleteSupervisor(id1);

        if (cl1 != null) {
            con.status(204);
        } else {
            con.status(404);
        }
    };






    private void populateResult(Context context, Supervisor a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }
}
