package com.revature.project1.services;


import com.revature.project1.models.Supervisor;
import com.revature.project1.repositories.SupervisorRepo;

public class SupervisorServiceImpl implements SupervisorService{


    SupervisorRepo su;

    public SupervisorServiceImpl(SupervisorRepo su) {

        this.su = su;
    }
    @Override
    public Supervisor addSupervisor(Supervisor s) {
        return su.addSupervisor(s);
    }

    @Override
    public Supervisor getSupervisor(int id) {
        return su.getSupervisor(id);
    }

    @Override
    public Supervisor updateSupervisor(Supervisor change) {
        return su.updateSupervisor(change);
    }

    @Override
    public Supervisor deleteSupervisor(int id) {
        return su.deleteSupervisor(id);
    }
}
