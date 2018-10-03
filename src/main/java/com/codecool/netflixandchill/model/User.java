package com.codecool.netflixandchill.model;

import java.util.Date;
import java.util.List;

public class User {

    private long id;
    private String userName;
    private String emailAddress;
    private String password;
    private List<Episode> watchedEpisodes;
    private Date registrationDate;
}
