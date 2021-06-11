package com.innovativeapps.com.messagingapp.pojo;


import org.springframework.beans.factory.annotation.Configurable;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Configurable
public class AppUser implements Serializable {
    private static final long serialVersionUUID = 1L;
    private Integer Id;
    private String userName;
    private String gender;
    private Date joinDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null || o.getClass() != getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(userName, appUser.userName) &&
                Objects.equals(Id, appUser.Id) &&
                Objects.equals(gender, appUser.gender) &&
                Objects.equals(joinDate, appUser.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, userName, gender, joinDate);
    }
}
