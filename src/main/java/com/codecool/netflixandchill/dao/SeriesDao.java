package com.codecool.netflixandchill.dao;

import com.codecool.netflixandchill.model.Episode;
import com.codecool.netflixandchill.model.Series;

import java.util.List;

public interface SeriesDao {
    void add();
    Episode find(int id);
    void remove(int id);

    List<Series> getAll();
}
