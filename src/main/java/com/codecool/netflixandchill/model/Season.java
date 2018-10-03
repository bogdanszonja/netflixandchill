package com.codecool.netflixandchill.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany
    private List<Episode> episodes;
    private String title;
    private String description;
    private Date year;
    private int serialNumber;
    @ManyToOne
    private Series series;

    public Season(String title, String description, Date year, int serialNumber) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.serialNumber = serialNumber;
    }

    public Season() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
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
