package com.innovativeapps.com.messagingapp.pojo;

import com.innovativeapps.com.messagingapp.model.Message;
import com.innovativeapps.com.messagingapp.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AppShare implements Serializable {

    private Date sharedDate;
    private User user;
    private Message message;

    public Date getSharedDate() {
        return sharedDate;
    }

    public void setSharedDate(Date sharedDate) {
        this.sharedDate = sharedDate;
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
        AppShare appShare = (AppShare) o;
        return Objects.equals(sharedDate, appShare.sharedDate) &&
                Objects.equals(user, appShare.user) &&
                Objects.equals(message, appShare.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharedDate, user, message);
    }
}
