package com.revature.project1.repositories;


import com.revature.project1.models.Supervisor;

public interface SupervisorRepo {
    public Supervisor addSupervisor(Supervisor bca);
    public Supervisor getSupervisor(int id);
    public Supervisor updateSupervisor(Supervisor change);
    public Supervisor deleteSupervisor(int id);
}
