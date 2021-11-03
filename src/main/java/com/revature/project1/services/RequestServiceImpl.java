package com.revature.project1.services;

import com.revature.project1.models.Request;
import com.revature.project1.repositories.RequestRepo;

import java.util.List;

public class RequestServiceImpl implements RequestService{

    RequestRepo r;

    public RequestServiceImpl(RequestRepo r) {

        this.r = r;
    }
    @Override
    public Request addRequest(Request rq) {
        return r.addRequest(rq);
    }

    @Override
    public Request getRequest(int id) {
        return r.getRequest(id);
    }

    @Override
    public List getAllRequest() {
        return r.getAllRequest();
    }

    @Override
    public Request updateRequest(Request change) {
        return r.updateRequest(change);
    }

    @Override
    public Request deleteRequest(int id) {
        return r.deleteRequest(id);
    }


}
