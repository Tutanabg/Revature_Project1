package com.revature.project1.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bca")
public class BCA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    String name;

    public BCA() {
    }

    public BCA(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BCA(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BCA)) return false;
        BCA bca = (BCA) o;
        return getId() == bca.getId() && Objects.equals(getName(), bca.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }


    @Override
    public String toString() {
        return "BCA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
