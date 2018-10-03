package com.codecool.netflixandchill.dao;

import com.codecool.netflixandchill.model.Season;

import java.util.List;

public interface SeasonDao {
    void add();
    Season find(int id);
    void remove(int id);

    List<Season> getAll();
}
