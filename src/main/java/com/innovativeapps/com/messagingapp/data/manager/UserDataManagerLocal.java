package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataManagerLocal {

    User create(User user);

    List<User> getAll();

    User get(Integer userId);

    User update(User user);
}
