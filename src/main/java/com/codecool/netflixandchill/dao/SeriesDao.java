package com.codecool.netflixandchill.dao;

import com.codecool.netflixandchill.model.Series;

import java.util.List;

public interface SeriesDao {
    void add();

    Series find(long seriesId);

    List<Series> getAll();
}
