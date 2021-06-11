package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.data.provider.DataproviderLocal;
import com.innovativeapps.com.messagingapp.model.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LikeDataManager implements LikeDataManagerLocal {

    @Autowired
    private DataproviderLocal crud;

    @Override
    public Like create(Like like) { return crud.create(like); }

    @Override
    public List<Like> getAll() { return crud.findAll(Like.class); }
}
