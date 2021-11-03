package com.revature.project1.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grades")
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    String presentation;

    @Column
    String class_grade;

    public Grades() {
    }

    public Grades(int id, String presentation, String class_grade) {
        this.id = id;
        this.presentation = presentation;
        this.class_grade = class_grade;
    }

    public Grades(String presentation, String class_grade) {
        this.presentation = presentation;
        this.class_grade = class_grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getClass_grade() {
        return class_grade;
    }

    public void setClass_grade(String class_grade) {
        this.class_grade = class_grade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grades)) return false;
        Grades grades = (Grades) o;
        return getId() == grades.getId() && Objects.equals(getPresentation(), grades.getPresentation()) && Objects.equals(getClass_grade(), grades.getClass_grade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPresentation(), getClass_grade());
    }


    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", presentation='" + presentation + '\'' +
                ", class_grade='" + class_grade + '\'' +
                '}';
    }
}
