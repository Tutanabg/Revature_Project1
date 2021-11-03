package com.revature.project1.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    String s_name;

    public Supervisor() {
    }

    public Supervisor(int id, String s_name) {
        this.id = id;
        this.s_name = s_name;
    }

    public Supervisor(String s_name) {
        this.s_name = s_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supervisor)) return false;
        Supervisor that = (Supervisor) o;
        return getId() == that.getId() && Objects.equals(getS_name(), that.getS_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getS_name());
    }


    @Override
    public String toString() {
        return "Supervisor{" +
                "id=" + id +
                ", s_name='" + s_name + '\'' +
                '}';
    }
}
