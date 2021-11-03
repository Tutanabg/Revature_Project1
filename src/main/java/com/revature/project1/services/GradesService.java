package com.revature.project1.services;


import com.revature.project1.models.Grades;

public interface GradesService {
    public Grades addGrades(Grades bca);
    public Grades getGrades(int id);
    public Grades updateGrades(Grades change);
    public Grades deleteGrades(int id);
}
