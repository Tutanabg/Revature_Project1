package com.revature.project1.repositories;


import com.revature.project1.models.BCA;
import com.revature.project1.models.Events;
import com.revature.project1.services.EventsService;
import com.revature.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EventsRepoHBImpl implements EventsRepo {

    EventsRepo ev;

    public EventsRepoHBImpl(EventsRepo ev) {

        this.ev = ev;
    }

    public EventsRepoHBImpl() {

    }

    @Override
    public Events addEvents(Events ev) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(ev);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return ev;
    }

    @Override
    public Events getEvents(int id) {
        Session session = HibernateUtil.getSession();
        Events a = null;

        try {
            a = session.get(Events.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }

    @Override
    public Events updateEvents(Events change) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(change);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return change;
    }

    @Override
    public Events deleteEvents(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Events m = null;

        try {
            tx = session.beginTransaction();
            m = session.get(Events.class, id);
            session.delete(m);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return m;
    }
}
