package com.revature.project1.repositories;


import com.revature.project1.models.BCA;
import com.revature.project1.models.Grades;
import com.revature.project1.services.GradesService;
import com.revature.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GradesRepoHBImpl implements GradesRepo {

    GradesRepo g;

    public GradesRepoHBImpl(GradesRepo g) {

        this.g = g;
    }

    public GradesRepoHBImpl() {

    }

    @Override
    public Grades addGrades(Grades gr) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(gr);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return gr;
    }

    @Override
    public Grades getGrades(int id) {
        Session session = HibernateUtil.getSession();
        Grades a = null;

        try {
            a = session.get(Grades.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }

    @Override
    public Grades updateGrades(Grades change) {
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
    public Grades deleteGrades(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Grades m = null;

        try {
            tx = session.beginTransaction();
            m = session.get(Grades.class, id);
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
