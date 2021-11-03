package com.revature.project1.unittest;

import com.revature.project1.models.Events;
import com.revature.project1.repositories.EventsRepo;
import com.revature.project1.repositories.EventsRepoHBImpl;
import com.revature.project1.services.EventsService;
import com.revature.project1.services.EventsServiceImpl;
import org.junit.Test;

public class EventsServiceTest {
    EventsRepo bc = new EventsRepoHBImpl();
    EventsService a = new EventsServiceImpl(bc);
    EventsService b = new EventsServiceImpl(bc);



    @Test
    public void addEvents() {
        Events m = new Events( "Training");
        a.addEvents(m);

    }


    @Test
    public void getBCA() {
        Events m = new Events( "Training");
        a.addEvents(m);
        a.getEvents(m.getId());

    }

    @Test
    public void updateEvents(){
        Events m = new Events( "Training");
        a.addEvents(m);
        Events n = new Events( "Certificate");
        b.addEvents(n);
        a.updateEvents(n);

    }

    @Test
    public void deleteEvents(){
        Events m = new Events( "Certificate");
        a.addEvents(m);
        a.deleteEvents(m.getId());

    }
}
