package com.revature.project1.services;

import com.revature.project1.models.BCA;

public interface BCAService {
    public BCA addBCA(BCA bca);
    public BCA getBCA(int id);
    public BCA updateBCA(BCA change);
    public BCA deleteBCA(int id);
}
