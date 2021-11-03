package com.revature.project1.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emails")
public class Emails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int em_id;


    @Column
    String em_from;

    @Column
    String em_to;

    @Column
    String em_subject;

    @Column
    String em_body;

    public Emails() {
    }

    public Emails(int em_id, String em_from, String em_to, String em_subject, String em_body) {
        this.em_id = em_id;
        this.em_from = em_from;
        this.em_to = em_to;
        this.em_subject = em_subject;
        this.em_body = em_body;
    }

    public Emails(String em_from, String em_to, String em_subject, String em_body) {
        this.em_from = em_from;
        this.em_to = em_to;
        this.em_subject = em_subject;
        this.em_body = em_body;
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public String getEm_from() {
        return em_from;
    }

    public void setEm_from(String em_from) {
        this.em_from = em_from;
    }

    public String getEm_to() {
        return em_to;
    }

    public void setEm_to(String em_to) {
        this.em_to = em_to;
    }

    public String getEm_subject() {
        return em_subject;
    }

    public void setEm_subject(String em_subject) {
        this.em_subject = em_subject;
    }

    public String getEm_body() {
        return em_body;
    }

    public void setEm_body(String em_body) {
        this.em_body = em_body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emails)) return false;
        Emails emails = (Emails) o;
        return getEm_id() == emails.getEm_id() && Objects.equals(getEm_from(), emails.getEm_from()) && Objects.equals(getEm_to(), emails.getEm_to()) && Objects.equals(getEm_subject(), emails.getEm_subject()) && Objects.equals(getEm_body(), emails.getEm_body());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEm_id(), getEm_from(), getEm_to(), getEm_subject(), getEm_body());
    }

    @Override
    public String toString() {
        return "Emails{" +
                "em_id=" + em_id +
                ", em_from='" + em_from + '\'' +
                ", em_to='" + em_to + '\'' +
                ", em_subject='" + em_subject + '\'' +
                ", em_body='" + em_body + '\'' +
                '}';
    }
}
