package com.innovativeapps.com.messagingapp.pojo;

import com.innovativeapps.com.messagingapp.model.Message;
import com.innovativeapps.com.messagingapp.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AppComment implements Serializable {

    private Date createdDate;
    private User user;
    private String content;
    private Message message;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        AppComment appComment = (AppComment) o;
        return Objects.equals(createdDate, appComment.createdDate) &&
                Objects.equals(message, appComment.message) &&
                Objects.equals(content, appComment.content) &&
                Objects.equals(user, appComment.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdDate, message,content, user);
    }
}
