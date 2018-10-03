package com.codecool.netflixandchill.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Season extends BaseModel {

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes;

    @Temporal(TemporalType.DATE)
    private Date year;

    private int serialNumber;

    @ManyToOne
    private Series series;

    public Season(String title, String description, Date year, int serialNumber) {
        super(title, description);
        this.year = year;
        this.serialNumber = serialNumber;
    }

    public Season() {
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }
}
