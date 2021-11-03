package com.revature.project1.repositories;


import com.revature.project1.models.Grades;

public interface GradesRepo {
    public Grades addGrades(Grades bca);
    public Grades getGrades(int id);
    public Grades updateGrades(Grades change);
    public Grades deleteGrades(int id);
}
