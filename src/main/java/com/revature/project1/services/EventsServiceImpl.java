package com.revature.project1.services;


import com.revature.project1.models.Events;
import com.revature.project1.repositories.EventsRepo;

public class EventsServiceImpl implements EventsService{

    EventsRepo ev;

    public EventsServiceImpl(EventsRepo ev) {

        this.ev = ev;
    }
    @Override
    public Events addEvents(Events e) {
        return ev.addEvents(e);
    }

    @Override
    public Events getEvents(int id) {
        return ev.getEvents(id);
    }

    @Override
    public Events updateEvents(Events change) {
        return ev.updateEvents(change);
    }

    @Override
    public Events deleteEvents(int id) {
        return ev.deleteEvents(id);
    }
}
