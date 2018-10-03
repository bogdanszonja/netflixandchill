package com.codecool.netflixandchill.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nickname;

    @Column(unique = true)
    private String emailAddress;

    private String password;

    @ManyToMany
    private List<Episode> watchedEpisodes = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    public User() {
    }

    public User(String nickname, String emailAddress, String password, Date registrationDate) {
        this.nickname = nickname;
        this.emailAddress = emailAddress;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String userName) {
        this.nickname = userName;
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

    public void addEpisode(Episode episode) {
        watchedEpisodes.add(episode);
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}