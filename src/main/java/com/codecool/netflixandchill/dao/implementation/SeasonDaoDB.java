package com.codecool.netflixandchill.dao.implementation;

import com.codecool.netflixandchill.dao.SeasonDao;
import com.codecool.netflixandchill.model.Episode;
import com.codecool.netflixandchill.model.Season;
import com.codecool.netflixandchill.util.EMFManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class SeasonDaoDB implements SeasonDao {
    private EntityManagerFactory emfManager = EMFManager.getInstance();

    @Override
    public void add() {

    }

    @Override
    public Season find(long seasonId) {
        return null;
    }

    @Override
    public List<Season> getAll() {
        EntityManager em = emfManager.createEntityManager();

        return em.createQuery(
                "SELECT e " +
                        "FROM Season e ", Season.class)
                .getResultList();
    }
}
