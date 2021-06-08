package com.innovativeapps.com.messagingapp.pojo;

import com.innovativeapps.com.messagingapp.model.Message;
import com.innovativeapps.com.messagingapp.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AppLike implements Serializable {

    private Date likedDate;
    private User user;
    private Message message;

    public Date getLikedDate() {
        return likedDate;
    }

    public void setLikedDate(Date likedDate) {
        this.likedDate = likedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null || o.getClass() != getClass()) return false;
        AppLike appLike = (AppLike) o;
        return Objects.equals(likedDate, appLike.likedDate) &&
                Objects.equals(user, appLike.user) &&
                Objects.equals(message, appLike.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likedDate, user, message);
    }
}
