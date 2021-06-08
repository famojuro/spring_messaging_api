package com.innovativeapps.com.messagingapp.pojo;

import com.innovativeapps.com.messagingapp.model.Comment;
import com.innovativeapps.com.messagingapp.model.Share;
import com.innovativeapps.com.messagingapp.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AppMessage implements Serializable {

    private String content;
    private Date createdDate;
    private User user;
    private List<Comment> commentList;
    private List<Share> shareList;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Share> getShareList() {
        return shareList;
    }

    public void setShareList(List<Share> shareList) {
        this.shareList = shareList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null || o.getClass() != getClass()) return false;
        AppMessage appMessage = (AppMessage) o;
        return Objects.equals(content, appMessage.content) &&
                Objects.equals(createdDate, appMessage.createdDate) &&
                Objects.equals(user, appMessage.user) &&
                Objects.equals(commentList, appMessage.commentList) &&
                Objects.equals(shareList, appMessage.shareList);
    }
}
