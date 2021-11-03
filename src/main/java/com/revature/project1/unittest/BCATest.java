package com.revature.project1.unittest;

import com.revature.project1.models.BCA;
import com.revature.project1.repositories.BCARepo;
import com.revature.project1.repositories.BCARepoHBImpl;
import org.junit.Test;

import static org.junit.Assert.*;


public class BCATest {
    BCARepo bc = new BCARepoHBImpl();
    BCA a = new BCA();
    BCA b = new BCA();


    @Test
    public void addBCA() {
        a.setName("Employee");
        a = bc.addBCA(a);
        assertEquals("Employee", a.getName());

    }

    @Test
    public void getBCA(){
        a.setName("Employee");
        a = bc.addBCA(a);
        a = bc.getBCA(a.getId());
        assertEquals("Employee", a.getName());
    }

    @Test
    public void updateBCA(){
        a.setName("Employee");
        a = bc.addBCA(a);
        b.setName("Employee1");
        a = bc.addBCA(b);
        b = bc.updateBCA(a);
        assertEquals("Employee1", a.getName());

    }

    @Test
    public void deleteBCA(){
        a.setName("Employee5");
        a = bc.addBCA(a);
        b = bc.deleteBCA(a.getId());
        assertEquals("", "");
    }

}
