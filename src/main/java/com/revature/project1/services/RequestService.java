package com.revature.project1.services;

import com.revature.project1.models.Request;

import java.util.List;

public interface RequestService {
    public Request addRequest(Request rq);
    public Request getRequest(int id);
    public List getAllRequest();
    public Request updateRequest(Request change);
   public Request deleteRequest(int id);

}
