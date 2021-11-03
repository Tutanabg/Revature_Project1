package com.revature.project1.repositories;


import com.revature.project1.models.Events;

public interface EventsRepo {
    public Events addEvents(Events bca);
    public Events getEvents(int id);
    public Events updateEvents(Events change);
    public Events deleteEvents(int id);
}
