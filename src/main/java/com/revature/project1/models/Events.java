package com.revature.project1.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Events {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    String events;


    public Events() {
    }

    public Events(int id, String events) {
        this.id = id;
        this.events = events;
    }

    public Events(String events) {
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Events)) return false;
        Events events1 = (Events) o;
        return getId() == events1.getId() && Objects.equals(getEvents(), events1.getEvents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEvents());
    }


    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", events='" + events + '\'' +
                '}';
    }
}
