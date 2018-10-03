package com.codecool.netflixandchill.model;

import java.util.Date;
import java.util.List;

public class Season {

    private long id;
    private List<Episode> episodes;
    private String title;
    private String description;
    private Date year;
    private int serialNumber;
    private Series series;
}
