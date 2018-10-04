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
        Episode episode = Episode.builder().title("b").description("dasd").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode2 = Episode.builder().title("b b").description("dsasd").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode3 = Episode.builder().title("bbb").description("dasd").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode4 = Episode.builder().title("bbbbb").description("dagfsdasd").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode5 = Episode.builder().title("bbbbbb").description("ddgtrsd").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode6 = Episode.builder().title("bbbbbbbb").description("dazthbtzdasd").releaseDate(new Date()).runtime(45).serialNumber(0).build();

        User user = User.builder().emailAddress("oli").password("pina").registrationDate(new Date()).userName("olcsi").build();
        user.addWatchedEpisodes(episode);
        user.addWatchedEpisodes(episode2);
        user.addWatchedEpisodes(episode3);
        user.addWatchedEpisodes(episode4);
        user.addWatchedEpisodes(episode5);
        user.addWatchedEpisodes(episode6);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(series);
        em.persist(season);
        em.persist(user);
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
