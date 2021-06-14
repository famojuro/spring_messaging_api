package com.innovativeapps.com.messagingapp.model;

import com.innovativeapps.com.messagingapp.util.hateoas.Link;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    private static final long serialVersionUUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Basic
    @Column(name = "content", nullable = false, length = 2000)
    private String content;
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToMany()
    private List<Comment> commentList;
    @OneToMany
    private List<Share> shareList;

    public Message() {
    }

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

    public Integer getId() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(Id, message.Id) &&
                Objects.equals(content,message.content) &&
                Objects.equals(createdDate, message.createdDate) &&
                Objects.equals(commentList, message.commentList) &&
                Objects.equals(shareList, message.shareList) &&
                Objects.equals(user, message.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id,content, commentList, createdDate, shareList, user);
    }
}
