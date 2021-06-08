package com.innovativeapps.com.messagingapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "like")
public class Like implements Serializable {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date likedDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    private Message message;

    public Like() {
    }

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
        if (o == null || o.getClass() != getClass()) return false;
        Like like = (Like) o;
        return Objects.equals(id, like.id) &&
                Objects.equals(likedDate, like.likedDate) &&
                Objects.equals(message, like.message) &&
                Objects.equals(user, like.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, likedDate, message, user);
    }
}
