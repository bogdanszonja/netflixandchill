package com.codecool.netflixandchill.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Episode extends BaseModel {

    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private int runtime;

    @Column(nullable = false)
    private int serialNumber;

    @ManyToOne
    private Season season;

    @ManyToMany(mappedBy = "watchedEpisodes")
    private List<User> users = new ArrayList<>();

    public Episode(String title, String description, Date releaseDate, int runtime, int serialNumber) {
        super(title, description);
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.serialNumber = serialNumber;
    }

    public Episode() {
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
