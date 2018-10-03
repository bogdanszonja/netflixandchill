package com.codecool.netflixandchill.dao;

import com.codecool.netflixandchill.model.Episode;

import java.util.List;

public interface EpisodeDao {
    void add();
    Episode find(int id);
    void remove(int id);

    List<Episode> getAll();
}
