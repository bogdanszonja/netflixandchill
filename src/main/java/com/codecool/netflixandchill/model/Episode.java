package com.codecool.netflixandchill.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Episode extends BaseModel {

    private Date releaseDate;

    private int runtime;

    private int serialNumber;

    @ManyToOne
    private Season season;

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
}
