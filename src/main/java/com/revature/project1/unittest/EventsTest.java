package com.revature.project1.unittest;

import com.revature.project1.models.Events;
import com.revature.project1.repositories.EventsRepo;
import com.revature.project1.repositories.EventsRepoHBImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EventsTest {
    EventsRepo bc = new EventsRepoHBImpl();
    Events a = new Events();
    Events b = new Events();


    @Test
    public void addEvents() {
        a.setEvents("Training");
        a = bc.addEvents(a);
        assertEquals("Training", a.getEvents());

    }

    @Test
    public void getEvents(){
        a.setEvents("Training");
        a = bc.addEvents(a);
        a = bc.getEvents(a.getId());
        assertEquals("Training", a.getEvents());
    }

    @Test
    public void updateEvents(){
        a.setEvents("Training");
        a = bc.addEvents(a);
        b.setEvents("Certificate");
        a = bc.addEvents(b);
        b = bc.updateEvents(a);
        assertEquals("Certificate", a.getEvents());

    }

    @Test
    public void deleteEvents(){
        a.setEvents("Certificate");
        a = bc.addEvents(a);
        b = bc.deleteEvents(a.getId());
        assertEquals("", "");
    }
}
