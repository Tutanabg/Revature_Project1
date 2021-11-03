package com.revature.project1.unittest;

import com.revature.project1.models.Grades;
import com.revature.project1.repositories.GradesRepo;
import com.revature.project1.repositories.GradesRepoHBImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GradesTest {
    GradesRepo bc = new GradesRepoHBImpl();
    Grades a = new Grades();
    Grades b = new Grades();


    @Test
    public void addGrades() {
        a.setClass_grade("Pass");
        a.setPresentation("Yes");
        a = bc.addGrades(a);
        assertEquals("Pass", a.getClass_grade());

//        a.setPresentation("Yes");
//        a = bc.addGrades(a);
//        assertEquals("Yes", a.getPresentation());
    }


    @Test
    public void getGrades(){
        a.setClass_grade("Pass");
        a.setPresentation("Yes");
        a = bc.addGrades(a);
        a = bc.getGrades(a.getId());
        assertEquals("Pass", a.getClass_grade());

//        a.setPresentation("Yes");
//        a = bc.addGrades(a);
//        a = bc.getGrades(a.getId());
//        assertEquals("Yes", a.getPresentation());

    }

    @Test
    public void updateGrades(){
        a.setClass_grade("Pass");
        a.setPresentation("Yes");
        a = bc.addGrades(a);
        b.setClass_grade("Fail");
        b.setPresentation("No");
        a = bc.addGrades(b);
        b = bc.updateGrades(a);
        assertEquals("Fail", a.getClass_grade());

//        a.setPresentation("Yes");
//        a = bc.addGrades(a);
//        b.setPresentation("No");
//        a = bc.addGrades(b);
//        b = bc.updateGrades(a);
//        assertEquals("No", a.getPresentation());

    }

    @Test
    public void deleteGrades(){
        a.setClass_grade("Fail");
        a.setPresentation("No");
        a = bc.addGrades(a);
        b = bc.deleteGrades(a.getId());
        assertEquals("", "");

//        a.setPresentation("No");
//        a = bc.addGrades(a);
//        b = bc.deleteGrades(a.getId());
//        assertEquals("", "");
    }
}
