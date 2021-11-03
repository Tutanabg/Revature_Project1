package com.revature.project1.repositories;


import com.revature.project1.models.BCA;
import com.revature.project1.models.Employee;
import com.revature.project1.services.EmployeeService;
import com.revature.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeRepoHBImpl implements EmployeeRepo {

    EmployeeRepo e;

    public EmployeeRepoHBImpl(EmployeeRepo e) {

        this.e = e;
    }

    public EmployeeRepoHBImpl() {

    }

    @Override
    public Employee addEmployee(Employee em) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(em);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return em;
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Employee a = null;

        try {
            a = session.get(Employee.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }

    @Override
    public Employee updateEmployee(Employee change) {
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
    public Employee deleteEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Employee m = null;

        try {
            tx = session.beginTransaction();
            m = session.get(Employee.class, id);
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
