package com.revature.project1.controller;

import com.google.gson.Gson;
import com.revature.project1.models.BCA;
import com.revature.project1.models.Emails;
import com.revature.project1.services.BCAService;
import com.revature.project1.services.EmailsService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmailsController {
    EmailsService bca;
    Gson gson = new Gson();

    public EmailsController(EmailsService bca) {
        this.bca = bca;
    }

    //Add Emails
    public Handler addEmails = (context) -> {
        Emails b = gson.fromJson(context.body(), Emails.class);
        b = bca.addEmails(b);
        populateResult(context, b);
    };



//    Get Emails

    public Handler getEmails = (context) -> {
        String input = context.pathParam("id");
        int bcaId;

        try {
            bcaId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            bcaId = -1;
        }

        Emails cl = bca.getEmails(bcaId);

        if (cl != null) {
            context.result(gson.toJson(cl));

        } else {
            context.status(404);


        }
    };

    private void populateResult(Context context, Emails a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }
}
