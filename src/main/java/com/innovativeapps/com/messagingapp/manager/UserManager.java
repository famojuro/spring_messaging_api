package com.innovativeapps.com.messagingapp.manager;

import com.innovativeapps.com.messagingapp.data.manager.UserDataManagerLocal;
import com.innovativeapps.com.messagingapp.model.User;
import com.innovativeapps.com.messagingapp.pojo.AppUser;
import com.innovativeapps.com.messagingapp.pojo.UserPayload;
import com.innovativeapps.com.messagingapp.util.exception.AppException;
import com.innovativeapps.com.messagingapp.util.exception.GeneralAppException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RestController
public class UserManager implements UserManagerLocal {

    @Autowired
    private UserDataManagerLocal userDataManager;

    @Override
    public AppUser createUser(String userName, String gender) throws AppException {
        User user = new User();
        List<User> userList = userDataManager.getAll();
        for (User user1 : userList) {
            if (user1.getUserName().equals(userName)) {
                throw new GeneralAppException(404, 404, "User with username " + userName + " already exist",
                        "User with id already exist", "");
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

    public AppUser updateUser(String userId, String userName, String gender)
            throws GeneralAppException{
        User user = userDataManager.get(Integer.parseInt(userId));
        if (user == null) {
           throw new GeneralAppException(404, 404, "User with id " + userId + " not found", "user not found", "");
        }
        user.setUserName(userName);
        user.setGender(gender);
        user = userDataManager.update(user);

        return getAppUser(user);
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
    public AppUser getUser(String userId) throws AppException {
        User user = userDataManager.get(Integer.parseInt(userId));
        if (user == null) {
            throw new GeneralAppException(404, 404, "user with id " + userId + " not found", "user not found", "");
        }

        return getAppUser(user);
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
