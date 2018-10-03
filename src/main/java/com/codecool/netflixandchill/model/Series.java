package com.codecool.netflixandchill.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Date airDate;

    @OneToMany
    private List<Season> seasons;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Genre.class)
    private List<Genre> genres;

    public Series(String title, String description, Status status, Date airDate, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.airDate = airDate;
        this.genres = genres;
    }

    public Series() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
