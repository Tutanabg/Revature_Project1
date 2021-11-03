package com.revature.project1.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department_head")
public class DepartmentHead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    String dh_name;

    public DepartmentHead() {
    }

    public DepartmentHead(int id, String dh_name) {
        this.id = id;
        this.dh_name = dh_name;
    }

    public DepartmentHead(String dh_name) {
        this.dh_name = dh_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDh_name() {
        return dh_name;
    }

    public void setDh_name(String dh_name) {
        this.dh_name = dh_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentHead)) return false;
        DepartmentHead that = (DepartmentHead) o;
        return getId() == that.getId() && Objects.equals(getDh_name(), that.getDh_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDh_name());
    }


    @Override
    public String toString() {
        return "DepartmentHead{" +
                "id=" + id +
                ", dh_name='" + dh_name + '\'' +
                '}';
    }
}
