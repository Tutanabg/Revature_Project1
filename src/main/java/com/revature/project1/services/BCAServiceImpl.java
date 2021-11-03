package com.revature.project1.services;

import com.revature.project1.models.BCA;
import com.revature.project1.repositories.BCARepo;

public class BCAServiceImpl implements BCAService{

    BCARepo bca;

    public BCAServiceImpl(BCARepo bca) {

        this.bca = bca;
    }

    public BCAServiceImpl() {

    }

    @Override
    public BCA addBCA(BCA bc) {
        return bca.addBCA(bc);
    }

    @Override
    public BCA getBCA(int id) {
        return bca.getBCA(id);
    }

    @Override
    public BCA updateBCA(BCA change) {
        return bca.updateBCA(change);
    }

    @Override
    public BCA deleteBCA(int id) {
        return bca.deleteBCA(id);
    }
}
