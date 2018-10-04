package com.codecool.netflixandchill.dao;

import com.codecool.netflixandchill.model.User;

import java.util.List;

public interface UserDao {
    void add();

    User find(long userId);

    void remove(long userId);

    List<User> getAll();
}
