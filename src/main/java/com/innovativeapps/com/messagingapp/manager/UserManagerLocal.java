package com.innovativeapps.com.messagingapp.manager;

import com.innovativeapps.com.messagingapp.model.User;
import com.innovativeapps.com.messagingapp.pojo.AppUser;
import com.innovativeapps.com.messagingapp.pojo.UserPayload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserManagerLocal {

    AppUser createUser(String userName, String gender) throws RuntimeException;

    AppUser updateUser(String userId, String userName, String gender) throws RuntimeException;

    AppUser getUser(String userId);

    UserPayload getUsers();

}
