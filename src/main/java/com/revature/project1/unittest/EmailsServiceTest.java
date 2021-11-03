package com.revature.project1.unittest;

import com.revature.project1.models.BCA;
import com.revature.project1.models.Emails;
import com.revature.project1.repositories.BCARepo;
import com.revature.project1.repositories.BCARepoHBImpl;
import com.revature.project1.repositories.EmailsRepo;
import com.revature.project1.repositories.EmailsRepoHBImpl;
import com.revature.project1.services.BCAService;
import com.revature.project1.services.BCAServiceImpl;
import com.revature.project1.services.EmailsService;
import com.revature.project1.services.EmailsServiceImpl;
import org.junit.Test;

public class EmailsServiceTest {
    EmailsRepo bc = new EmailsRepoHBImpl();
    EmailsService a = new EmailsServiceImpl(bc);




    @Test
    public void addEmails() {
        Emails m = new Emails("from", "to", "subject", "body");
        a.addEmails(m);

    }


    @Test
    public void getEmails() {
        Emails m = new Emails( "from", "to", "subject", "body");
        a.addEmails(m);
        a.getEmails(m.getEm_id());

    }
}
