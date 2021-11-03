package com.revature.project1.services;


import com.revature.project1.models.Events;

public interface EventsService {
    public Events addEvents(Events bca);
    public Events getEvents(int id);
    public Events updateEvents(Events change);
    public Events deleteEvents(int id);
}
