package com.codecool.netflixandchill;

import com.codecool.netflixandchill.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SimulateJPA {

    public static void populateDb(EntityManager em) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseDate = Calendar.getInstance().getTime();
        Date airDate = Calendar.getInstance().getTime();
        Date year = Calendar.getInstance().getTime();
        try {
            releaseDate = sdf.parse("1997-07-21");
            airDate = sdf.parse("1993-12-01");
            year = sdf.parse("1993-12-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Series series = Series.builder().title("Szonja").description("Anita").airDate(new Date())
                .status(Status.RUNNING).genres(Collections.singletonList(Genre.HORROR)).build();
        Season season = Season.builder().title("Oli").description("Zoli").year(new Date()).serialNumber(1).build();
        Episode episode = Episode.builder().title("b").description("dasdasd").releaseDate(new Date()).runtime(45).serialNumber(0).build();

        System.out.println(series.getTitle());
        System.out.println(series.getDescription());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(series);
        em.persist(season);
        em.persist(episode);
        transaction.commit();

    }

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        Map<String, Object> configOverrides = new HashMap<>();
        for (String envName : env.keySet()) {
            if (envName.contains("DB_USER_NAME")) {
                configOverrides.put("javax.persistence.jdbc.user", env.get(envName));
            }
            if (envName.contains("DB_PASSWORD")) {
                configOverrides.put("javax.persistence.jdbc.password", env.get(envName));
            }
        }

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("netflixandchill", configOverrides);
        EntityManager em = emf.createEntityManager();

        populateDb(em);
        em.clear(); //clear hibernate cache - force next statements to read data from db

        em.close();
        emf.close();

    }
}
