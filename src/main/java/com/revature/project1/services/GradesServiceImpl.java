package com.revature.project1.services;


import com.revature.project1.models.Grades;
import com.revature.project1.repositories.GradesRepo;

public class GradesServiceImpl implements GradesService{

    GradesRepo g;

    public GradesServiceImpl(GradesRepo g) {

        this.g = g;
    }

    @Override
    public Grades addGrades(Grades gr) {
        return g.addGrades(gr);
    }

    @Override
    public Grades getGrades(int id) {
        return g.getGrades(id);
    }

    @Override
    public Grades updateGrades(Grades change) {
        return g.updateGrades(change);
    }

    @Override
    public Grades deleteGrades(int id) {
        return g.deleteGrades(id);
    }
}
