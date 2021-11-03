package com.revature.project1.repositories;

import com.revature.project1.models.Request;

import java.util.List;

public interface RequestRepo {
    public Request addRequest(Request rq);
    public Request getRequest(int id);
    public List getAllRequest();
    public Request updateRequest(Request change);
    public Request deleteRequest(int id);

}
