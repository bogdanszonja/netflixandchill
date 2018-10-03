package com.codecool.netflixandchill.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Series extends BaseModel {

    private Status status;

    private Date airDate;
    @OneToMany(mappedBy = "series")

    private List<Season> seasons;
//    @Enumerated
//    private List<Genre> genres;

    public Series() {
    }

    public Series(String title, String description, Status status, Date airDate) {
        super(title, description);
        this.status = status;
        this.airDate = airDate;
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

//    public List<Genre> getGenres() {
//        return genres;
//    }
//
//    public void setGenres(List<Genre> genres) {
//        this.genres = genres;
//    }

    public void addSeason(Season season) {
        seasons.add(season);
    }
}
