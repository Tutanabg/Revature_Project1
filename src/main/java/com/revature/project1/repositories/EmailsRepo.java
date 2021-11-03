package com.revature.project1.repositories;

import com.revature.project1.models.BCA;
import com.revature.project1.models.Emails;

public interface EmailsRepo {
    public Emails addEmails(Emails a);
    public Emails getEmails(int id);

}
