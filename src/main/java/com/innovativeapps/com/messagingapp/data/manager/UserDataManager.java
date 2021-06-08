package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.data.provider.DataproviderLocal;
import com.innovativeapps.com.messagingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDataManager implements UserDataManagerLocal{

    @Autowired
    private DataproviderLocal crud;

    @Override
    public User create(User user) { return crud.create(user); }

    @Override
    public List<User> getAll() { return crud.findAll(User.class); }

    @Override
    public User get(String userId) { return crud.find(userId, User.class); }
}
