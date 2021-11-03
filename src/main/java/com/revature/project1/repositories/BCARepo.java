package com.revature.project1.repositories;

import com.revature.project1.models.BCA;

public interface BCARepo {
    public BCA addBCA(BCA a);
    public BCA getBCA(int id);
    public BCA updateBCA(BCA change);
    public BCA deleteBCA(int id);
}
