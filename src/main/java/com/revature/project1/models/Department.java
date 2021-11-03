package com.revature.project1.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    String d_name;

    @ManyToOne
    @JoinColumn(name = "dh_id")

    private DepartmentHead d_head;


    public Department(int id, String d_name, DepartmentHead d_head) {
        this.id = id;
        this.d_name = d_name;
        this.d_head = d_head;
    }

    public Department(String d_name, DepartmentHead d_head) {
        this.d_name = d_name;
        this.d_head = d_head;
    }

    public Department() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public DepartmentHead getD_head() {
        return d_head;
    }

    public void setD_head(DepartmentHead d_head) {
        this.d_head = d_head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getId() == that.getId() && Objects.equals(getD_name(), that.getD_name()) && Objects.equals(getD_head(), that.getD_head());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getD_name(), getD_head());
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", d_name='" + d_name + '\'' +
                ", d_head=" + d_head +
                '}';
    }
}
