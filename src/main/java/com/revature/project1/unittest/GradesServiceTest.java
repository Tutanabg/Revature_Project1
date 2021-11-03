package com.revature.project1.unittest;

import com.revature.project1.models.Grades;
import com.revature.project1.repositories.GradesRepo;
import com.revature.project1.repositories.GradesRepoHBImpl;
import com.revature.project1.services.GradesService;
import com.revature.project1.services.GradesServiceImpl;
import org.junit.Test;

public class GradesServiceTest {
    GradesRepo bc = new GradesRepoHBImpl();
    GradesService a = new GradesServiceImpl(bc);
    GradesService b = new GradesServiceImpl(bc);



    @Test
    public void addGrades() {
        Grades m = new Grades( "yes", "yes");
        a.addGrades(m);

    }


    @Test
    public void getGrades() {
        Grades m = new Grades( "yes", "yes");
        a.addGrades(m);
        a.getGrades(m.getId());

    }

    @Test
    public void updateGrades(){
        Grades m = new Grades( "yes", "yes");
        a.addGrades(m);
        Grades n = new Grades( "no", "no");
        b.addGrades(n);
        a.updateGrades(n);

    }

    @Test
    public void deleteGrades(){
        Grades m = new Grades( "yes", "yes");
        a.addGrades(m);
        a.deleteGrades(m.getId());

    }

}
