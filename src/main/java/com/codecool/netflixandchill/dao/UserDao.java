package com.codecool.netflixandchill.dao;

import com.codecool.netflixandchill.model.Episode;
import com.codecool.netflixandchill.model.User;

import java.util.List;

public interface UserDao {
    void add();
    Episode find(int id);
    void remove(int id);

    List<User> getAll();
}
