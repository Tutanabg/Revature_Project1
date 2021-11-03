package com.revature.project1.controller;

import com.google.gson.Gson;
import com.revature.project1.models.BCA;
import com.revature.project1.models.Grades;
import com.revature.project1.services.BCAService;
import com.revature.project1.services.GradesService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class GradesController {
    GradesService gr;
    Gson gson = new Gson();

    public GradesController(GradesService gr) {
        this.gr = gr;
    }

    //Add Grades
    public Handler addGrades = (context) -> {
        Grades b = gson.fromJson(context.body(), Grades.class);
        b = gr.addGrades(b);
        populateResult(context, b);
    };



//    Get Grades

    public Handler getGrades = (context) -> {
        String input = context.pathParam("id");
        int gradesId;

        try {
            gradesId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            gradesId = -1;
        }

        Grades cl = gr.getGrades(gradesId);

        if (cl != null) {
            context.result(gson.toJson(cl));

        } else {
            context.status(404);


        }
    };


//    Update Grades

    public Handler updateGrades = (con) -> {
        int id = Integer.parseInt(con.pathParam("id"));
        Grades cl = gson.fromJson(con.body(), Grades.class);


        cl = gr.updateGrades(cl);
        con.result((cl != null) ? gson.toJson(cl) : "{}");

    };




//    Delete Grades


    public Handler deleteGrades = (con) -> {
        int id1 = Integer.parseInt(con.pathParam("id"));
        Grades cl1 = gr.deleteGrades(id1);

        if (cl1 != null) {
            con.status(204);
        } else {
            con.status(404);
        }
    };






    private void populateResult(Context context, Grades a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }
}
