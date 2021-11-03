package com.revature.project1.controller;

import com.google.gson.Gson;
import com.revature.project1.models.BCA;
import com.revature.project1.models.Events;
import com.revature.project1.services.BCAService;
import com.revature.project1.services.EventsService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EventsController {
    EventsService ev;
    Gson gson = new Gson();

    public EventsController(EventsService ev) {
        this.ev = ev;
    }

    //Add Events
    public Handler addEvents = (context) -> {
        Events b = gson.fromJson(context.body(), Events.class);
        b = ev.addEvents(b);
        populateResult(context, b);
    };



//    Get Events

    public Handler getEvents = (context) -> {
        String input = context.pathParam("id");
        int eventsId;

        try {
            eventsId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            eventsId = -1;
        }

        Events cl = ev.getEvents(eventsId);

        if (cl != null) {
            context.result(gson.toJson(cl));

        } else {
            context.status(404);


        }
    };


//    Update BCA

    public Handler updateEvents = (con) -> {
        int id = Integer.parseInt(con.pathParam("id"));
        Events cl = gson.fromJson(con.body(), Events.class);


        cl = ev.updateEvents(cl);
        con.result((cl != null) ? gson.toJson(cl) : "{}");

    };




//    Delete BCA


    public Handler deleteEvents = (con) -> {
        int id1 = Integer.parseInt(con.pathParam("id"));
        Events cl1 = ev.deleteEvents(id1);

        if (cl1 != null) {
            con.status(204);
        } else {
            con.status(404);
        }
    };






    private void populateResult(Context context, Events a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }
}
