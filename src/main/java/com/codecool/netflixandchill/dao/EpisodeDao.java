package com.codecool.netflixandchill.dao;

import com.codecool.netflixandchill.model.Episode;

import java.util.List;

public interface EpisodeDao {
    void add();

    Episode find(long episodeId);

    List<Episode> getAll();
}
