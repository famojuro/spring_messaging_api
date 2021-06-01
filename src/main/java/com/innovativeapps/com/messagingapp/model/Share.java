package com.innovativeapps.com.messagingapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Share {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date sharedDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    private Message message;

    public Share() {

    }

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
        if (o == o || o.getClass() != getClass()) return false;
        Share share = (Share) o;
        return Objects.equals(Id, share.Id) &&
                Objects.equals(sharedDate, share.sharedDate) &&
                Objects.equals(message, share.message) &&
                Objects.equals(user, share.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, sharedDate, message, user);
    }
}
