package com.codecool.netflixandchill.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Series extends BaseModel {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Temporal(TemporalType.DATE)
    private Date airDate;

    @OneToMany(mappedBy = "series")
    @Column(nullable = false)
    private List<Season> seasons = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Genre.class)
    @Column(nullable = false)
    private List<Genre> genres = new ArrayList<>();

    public Series() {
    }

    public Series(String title, String description, Status status, Date airDate, List<Genre> genres) {
        super(title, description);
        this.status = status;
        this.airDate = airDate;
        this.genres = genres;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getAirDate() {
        return airDate;
    }

    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addSeason(Season season) {
        seasons.add(season);
    }
}
