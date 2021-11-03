package com.revature.project1.repositories;

import com.revature.project1.models.BCA;
import com.revature.project1.models.Emails;
import com.revature.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmailsRepoHBImpl implements EmailsRepo {

    EmailsRepo dh;

    public EmailsRepoHBImpl(EmailsRepo dh) {

        this.dh = dh;
    }

    public EmailsRepoHBImpl() {

    }

    @Override
    public Emails addEmails(Emails dh) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(dh);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return dh;

    }

    @Override
    public Emails getEmails(int id) {
        Session session = HibernateUtil.getSession();
        Emails a = null;

        try {
            a = session.get(Emails.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;


    }
}
