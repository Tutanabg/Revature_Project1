package com.revature.project1.unittest;

import com.revature.project1.models.BCA;
import com.revature.project1.models.Emails;
import com.revature.project1.repositories.BCARepo;
import com.revature.project1.repositories.BCARepoHBImpl;
import com.revature.project1.repositories.EmailsRepo;
import com.revature.project1.repositories.EmailsRepoHBImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailsTest {
    EmailsRepo bc = new EmailsRepoHBImpl();
    Emails a = new Emails();
    Emails b = new Emails();


    @Test
    public void addEmails() {
        a.setEm_subject("hi");
        a = bc.addEmails(a);
        assertEquals("hi", a.getEm_subject());

    }

    @Test
    public void getEmails(){
        a.setEm_subject("hi");
        a = bc.addEmails(a);
        a = bc.getEmails(a.getEm_id());
        assertEquals("hi", a.getEm_subject());
    }
}
