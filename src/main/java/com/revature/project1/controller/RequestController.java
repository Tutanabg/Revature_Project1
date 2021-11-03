package com.revature.project1.controller;

import com.google.gson.Gson;
import com.revature.project1.models.BCA;
import com.revature.project1.models.Request;
import com.revature.project1.repositories.RequestRepo;
import com.revature.project1.services.BCAService;
import com.revature.project1.services.RequestService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class RequestController {

    RequestRepo ar;
    Gson gsonn = new Gson();

    public RequestController(RequestRepo ar) {
        this.ar = ar;
    }




    RequestService req;
    Gson gson = new Gson();

    public RequestController(RequestService req) {
        this.req = req;
    }

    //Add BCA
    public Handler addRequest = (context) -> {
        Request b = gson.fromJson(context.body(), Request.class);
        b = req.addRequest(b);
        populateResult(context, b);
    };



//    Get BCA

    public Handler getRequest = (context) -> {
        String input = context.pathParam("id");
        int requestId;

        try {
            requestId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            requestId = -1;
        }

        Request cl = req.getRequest(requestId);

        if (cl != null) {
            context.result(gson.toJson(cl));

        } else {
            context.status(404);


        }
    };


//    Update BCA

    public Handler updateRequest = (con) -> {
        int id = Integer.parseInt(con.pathParam("id"));
        Request cl = gson.fromJson(con.body(), Request.class);


        cl = req.updateRequest(cl);
        con.result((cl != null) ? gson.toJson(cl) : "{}");

    };

    public Handler getAllRequest = (context) -> {

        List<Request> requestList = ar.getAllRequest();

        if(requestList != null) {
            context.result(gsonn.toJson(requestList));
        } else {
            context.result("[]");
        }
    };





//    Delete BCA


    public Handler deleteRequest = (con) -> {
        int id1 = Integer.parseInt(con.pathParam("id"));
        Request cl1 = req.deleteRequest(id1);

        if (cl1 != null) {
            con.status(204);
        } else {
            con.status(404);
        }
    };








    private void populateResult(Context context, Request a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }



}
