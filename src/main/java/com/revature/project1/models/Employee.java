package com.revature.project1.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    String e_name;

    @Column
    String e_address;

    @Column
    String e_username;

    @Column
    String e_password;


    @ManyToOne
    @JoinColumn(name = "s_id")
    private Supervisor e_supervisor;

    @Column()
    String e_title;


    @ManyToOne
    @JoinColumn(name = "g_id")
    private Grades e_grade;

    @ManyToOne
    @JoinColumn(name = "d_id")
    private Department e_department;

    @Column()
    String e_email;

    public Employee() {
    }


    public Employee(int id, String e_name, String e_address, String e_username, String e_password, Supervisor e_supervisor, String e_title, Grades e_grade, Department e_department, String e_email) {
        this.id = id;
        this.e_name = e_name;
        this.e_address = e_address;
        this.e_username = e_username;
        this.e_password = e_password;
        this.e_supervisor = e_supervisor;
        this.e_title = e_title;
        this.e_grade = e_grade;
        this.e_department = e_department;
        this.e_email = e_email;
    }


    public Employee(String e_name, String e_address, String e_username, String e_password, Supervisor e_supervisor, String e_title, Grades e_grade, Department e_department, String e_email) {
        this.e_name = e_name;
        this.e_address = e_address;
        this.e_username = e_username;
        this.e_password = e_password;
        this.e_supervisor = e_supervisor;
        this.e_title = e_title;
        this.e_grade = e_grade;
        this.e_department = e_department;
        this.e_email = e_email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_address() {
        return e_address;
    }

    public void setE_address(String e_address) {
        this.e_address = e_address;
    }

    public String getE_username() {
        return e_username;
    }

    public void setE_username(String e_username) {
        this.e_username = e_username;
    }

    public String getE_password() {
        return e_password;
    }

    public void setE_password(String e_password) {
        this.e_password = e_password;
    }

    public Supervisor getE_supervisor() {
        return e_supervisor;
    }

    public void setE_supervisor(Supervisor e_supervisor) {
        this.e_supervisor = e_supervisor;
    }

    public String getE_title() {
        return e_title;
    }

    public void setE_title(String e_title) {
        this.e_title = e_title;
    }

    public Grades getE_grade() {
        return e_grade;
    }

    public void setE_grade(Grades e_grade) {
        this.e_grade = e_grade;
    }

    public Department getE_department() {
        return e_department;
    }

    public void setE_department(Department e_department) {
        this.e_department = e_department;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && Objects.equals(getE_name(), employee.getE_name()) && Objects.equals(getE_address(), employee.getE_address()) && Objects.equals(getE_username(), employee.getE_username()) && Objects.equals(getE_password(), employee.getE_password()) && Objects.equals(getE_supervisor(), employee.getE_supervisor()) && Objects.equals(getE_title(), employee.getE_title()) && Objects.equals(getE_grade(), employee.getE_grade()) && Objects.equals(getE_department(), employee.getE_department()) && Objects.equals(getE_email(), employee.getE_email());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getE_name(), getE_address(), getE_username(), getE_password(), getE_supervisor(), getE_title(), getE_grade(), getE_department(), getE_email());
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", e_name='" + e_name + '\'' +
                ", e_address='" + e_address + '\'' +
                ", e_username='" + e_username + '\'' +
                ", e_password='" + e_password + '\'' +
                ", e_supervisor=" + e_supervisor +
                ", e_title='" + e_title + '\'' +
                ", e_grade=" + e_grade +
                ", e_department=" + e_department +
                ", e_email='" + e_email + '\'' +
                '}';
    }
}
