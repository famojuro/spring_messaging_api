package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.data.provider.DataproviderLocal;
import com.innovativeapps.com.messagingapp.model.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShareDataManager implements ShareDataManagerLocal {

    @Autowired
    private DataproviderLocal crud;

    @Override
    public Share create(Share share) { return crud.create(share); }

    @Override
    public Share get(String shareId) { return crud.find(shareId, Share.class); }

    @Override
    public List<Share> getAll() { return crud.findAll(Share.class); }
}
