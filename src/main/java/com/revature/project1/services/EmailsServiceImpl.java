package com.revature.project1.services;

import com.revature.project1.models.BCA;
import com.revature.project1.models.Emails;
import com.revature.project1.repositories.BCARepo;
import com.revature.project1.repositories.EmailsRepo;

public class EmailsServiceImpl implements EmailsService{

    EmailsRepo bca;

    public EmailsServiceImpl(EmailsRepo bca) {

        this.bca = bca;
    }


    @Override
    public Emails addEmails(Emails bc) {
        return bca.addEmails(bc);
    }

    @Override
    public Emails getEmails(int id) {
        return bca.getEmails(id);
    }
}
