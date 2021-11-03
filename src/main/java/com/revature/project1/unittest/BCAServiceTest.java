package com.revature.project1.unittest;

import com.revature.project1.controller.BCAController;
import com.revature.project1.models.BCA;
import com.revature.project1.repositories.BCARepo;
import com.revature.project1.repositories.BCARepoHBImpl;
import com.revature.project1.services.BCAService;
import com.revature.project1.services.BCAServiceImpl;
import io.javalin.http.Handler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BCAServiceTest {
    BCARepo bc = new BCARepoHBImpl();
    BCAService a = new BCAServiceImpl(bc);
    BCAService b = new BCAServiceImpl(bc);



    @Test
    public void addBCA() {
       BCA m = new BCA( "Employee");
       a.addBCA(m);

    }


    @Test
    public void getBCA() {
        BCA m = new BCA( "Employee");
        a.addBCA(m);
        a.getBCA(m.getId());

    }

    @Test
    public void updateBCA(){
      BCA m = new BCA( "Employee");
      a.addBCA(m);
      BCA n = new BCA( "Employee1");
      b.addBCA(n);
      a.updateBCA(n);

    }

    @Test
    public void deleteBCA(){
      BCA m = new BCA( "Employee");
      a.addBCA(m);
      a.deleteBCA(m.getId());

    }

}
