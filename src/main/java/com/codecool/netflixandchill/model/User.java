package com.codecool.netflixandchill.model;

import java.util.Date;
import java.util.List;

public class User {

    private long id;

    private String userName;

    private String emailAddress;

    private String password;

    private List<Episode> watchedEpisodes;

    private Date registrationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Episode> getWatchedEpisodes() {
        return watchedEpisodes;
    }

    public void setWatchedEpisodes(List<Episode> watchedEpisodes) {
        this.watchedEpisodes = watchedEpisodes;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}