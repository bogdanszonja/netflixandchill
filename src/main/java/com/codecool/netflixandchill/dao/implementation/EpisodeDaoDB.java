package com.codecool.netflixandchill.dao.implementation;

import com.codecool.netflixandchill.dao.EpisodeDao;
import com.codecool.netflixandchill.model.Episode;
import com.codecool.netflixandchill.util.EMFManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EpisodeDaoDB implements EpisodeDao {
    private EntityManagerFactory emfManager = EMFManager.getInstance();

    @Override
    public void add() {
        EntityManager em = emfManager.createEntityManager();
    }

    @Override
    public Episode find(long episodeId) {
        return null;
    }

    @Override
    public List<Episode> getAll() {
        EntityManager em = emfManager.createEntityManager();
        List<Episode> result = em.createQuery(
                "SELECT e " +
                        "FROM Episode e ", Episode.class)
                .getResultList();
        return result;
    }
}
