package com.codecool.netflixandchill.dao.implementation;

import com.codecool.netflixandchill.dao.UserDao;
import com.codecool.netflixandchill.model.User;
import com.codecool.netflixandchill.util.EMFManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDaoDB implements UserDao {
    private EntityManagerFactory emfManager = EMFManager.getInstance();

    @Override
    public void add() {

    }

    @Override
    public User find(long userId) {
        EntityManager em = emfManager.createEntityManager();
        return em.find(User.class, userId);
    }

    @Override
    public void remove(long userId) {
        EntityManager em = emfManager.createEntityManager();
        User user = em.find(User.class, userId);
        em.remove(user);
    }

    @Override
    public List<User> getAll() {
        EntityManager em = emfManager.createEntityManager();

        List<User> result = em.createQuery(
                "SELECT u " +
                        "FROM Series u ", User.class)
                .getResultList();
        em.close();
        return result;
    }
}
