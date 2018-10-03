package com.codecool.jpaexample.model;

import java.util.Date;
import java.util.List;

public class Series {

    private long id;
    private String title;
    private String description;
    private Status status;
    private Date airDate;
    private List<Season> seasons;
    private List<Genre> genres;
}
