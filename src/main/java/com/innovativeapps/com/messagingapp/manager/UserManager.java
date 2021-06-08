package com.innovativeapps.com.messagingapp.manager;

import com.innovativeapps.com.messagingapp.config.ApplicationConfig;
import com.innovativeapps.com.messagingapp.data.manager.UserDataManagerLocal;
import com.innovativeapps.com.messagingapp.model.User;
import com.innovativeapps.com.messagingapp.pojo.AppUser;
import com.innovativeapps.com.messagingapp.pojo.UserPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class UserManager implements UserManagerLocal {

    @Autowired
    private UserDataManagerLocal userDataManager;

    @Override
    public AppUser createUser(String userName, String gender) throws Exception {
        User user = new User();
        List<User> userList = userDataManager.getAll();
        for (User user1 : userList) {
            if (user1.getUserName().equals(userName)) {
                throw new Exception("Username already exists");
            }
        }
        user.setUserName(userName);
        user.setGender(gender);
        user.setJoinDate(new Date());
        user = userDataManager.create(user);

        AppUser appUser = new AppUser();
        appUser.setId(user.getId());
        appUser.setUserName(user.getUserName());
        appUser.setGender(user.getGender());
        appUser.setJoinDate(user.getJoinDate());

        return appUser;
    }

    @Override
    public UserPayload getUsers() {
        List<User> users = userDataManager.getAll();

        List<AppUser> appUsers = getAppUsers(users);
        UserPayload userPayload = new UserPayload();
        userPayload.setUsers(appUsers);

        return userPayload;
    }

    @Override
    public AppUser getUser(String userId) {
        return null;
    }

    private List<AppUser> getAppUsers(List<User> users) {
        List<AppUser> appUsers = new ArrayList<>();
        for (User user : users) {
            AppUser appUser = getAppUser(user);
            if (appUser != null) {
                appUsers.add(appUser);
            }
        }
        appUsers.sort(Comparator.comparing(AppUser::getUserName));

        return appUsers;
    }

    private AppUser getAppUser(User user) {
        if (user == null) {
            return null;
        }

        AppUser appUser = new AppUser();
        appUser.setId(user.getId());
        appUser.setGender(user.getGender());
        appUser.setUserName(user.getUserName());
        appUser.setJoinDate(user.getJoinDate());

        return appUser;
    }
}
