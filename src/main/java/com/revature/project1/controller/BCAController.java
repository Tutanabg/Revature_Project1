package com.revature.project1.controller;

import com.google.gson.Gson;
import com.revature.project1.models.BCA;
import com.revature.project1.services.BCAService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class BCAController {
    BCAService bca;
    Gson gson = new Gson();

    public BCAController(BCAService bca) {
        this.bca = bca;
    }

//Add BCA
    public Handler addBCA = (context) -> {
        BCA b = gson.fromJson(context.body(), BCA.class);
        b = bca.addBCA(b);
        populateResult(context, b);
    };



//    Get BCA

    public Handler getBCA = (context) -> {
        String input = context.pathParam("id");
        int bcaId;

        try {
            bcaId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            bcaId = -1;
        }

        BCA cl = bca.getBCA(bcaId);

        if (cl != null) {
            context.result(gson.toJson(cl));

        } else {
            context.status(404);


        }
    };


//    Update BCA

    public Handler updateBCA = (con) -> {
        int id = Integer.parseInt(con.pathParam("id"));
        BCA cl = gson.fromJson(con.body(), BCA.class);


        cl = bca.updateBCA(cl);
        con.result((cl != null) ? gson.toJson(cl) : "{}");

    };




//    Delete BCA


    public Handler deleteBCA = (con) -> {
        int id1 = Integer.parseInt(con.pathParam("id"));
        BCA cl1 = bca.deleteBCA(id1);

        if (cl1 != null) {
            con.status(204);
        } else {
            con.status(404);
        }
    };




    private void populateResult(Context context, BCA a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }

}
