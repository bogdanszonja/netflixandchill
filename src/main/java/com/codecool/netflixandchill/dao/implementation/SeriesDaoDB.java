package com.codecool.netflixandchill.dao.implementation;

import com.codecool.netflixandchill.dao.SeriesDao;
import com.codecool.netflixandchill.model.Series;
import com.codecool.netflixandchill.util.EMFManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class SeriesDaoDB implements SeriesDao {
    private EntityManagerFactory emfManager = EMFManager.getInstance();

    @Override
    public void add() {

    }

    @Override
    public Series find(long seriesId) {
        EntityManager em = emfManager.createEntityManager();
        return em.find(Series.class, seriesId);
    }

    @Override
    public List<Series> getAll() {
        EntityManager em = emfManager.createEntityManager();

        List<Series> result = em.createQuery(
                "SELECT s " +
                        "FROM Series s ", Series.class)
                .getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Series> findBySubstring(String substring) {
        EntityManager em = emfManager.createEntityManager();
        List<Series> result = em.createQuery(
                "SELECT s " +
                        "FROM Series s WHERE s.title LIKE '" + substring + "'", Series.class)
                .getResultList();
        em.close();
        return result;

    }
}
