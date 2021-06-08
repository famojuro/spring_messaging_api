package com.innovativeapps.com.messagingapp.pojo;

import org.springframework.beans.factory.annotation.Configurable;

import java.util.ArrayList;
import java.util.List;

@Configurable
public class UserPayload {

    private List<AppUser> users = null;

    public UserPayload() {
        users = new ArrayList<>();
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> states) {
        this.users.addAll(states);
    }

    public void setUser(AppUser appState) {
        users.add(appState);
    }
}
