package com.codecool.netflixandchill.controller;

import com.codecool.netflixandchill.config.TemplateEngineUtil;
import com.codecool.netflixandchill.dao.EpisodeDao;
import com.codecool.netflixandchill.dao.UserDao;
import com.codecool.netflixandchill.dao.implementation.EpisodeDaoDB;
import com.codecool.netflixandchill.dao.implementation.UserDaoDB;
import com.codecool.netflixandchill.model.*;
import com.codecool.netflixandchill.util.EMFManager;
import com.codecool.netflixandchill.util.SessionManager;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

@WebServlet(urlPatterns = {"/"})
public class MainPageController extends HttpServlet {

    private static boolean firstVisit = true;
    private EpisodeDao episodeDao = EpisodeDaoDB.getInstance();
    private UserDao userDao = UserDaoDB.getInstance();
    private SessionManager sessionManager = SessionManager.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        if (firstVisit) {
            this.populateDb();
            firstVisit = false;
        }

        context.setVariable("episodes", episodeDao.getAll());

        engine.process("index.html", context, response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        HttpSession session = sessionManager.getHttpSessionRedirect(request);

        if (session == null) {
            response.sendRedirect("/");
            return;
        }

        userDao.addEpisode(episodeDao.find(Long.parseLong(request.getParameter("episode"))).getId(),
                (long) session.getAttribute("userId"));

        context.setVariable("episodes", episodeDao.getAll());

        engine.process("index.html", context, response.getWriter());
    }

    private void populateDb() {
        EntityManager em = EMFManager.getInstance().createEntityManager();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseDate = Calendar.getInstance().getTime();
        Date airDate = Calendar.getInstance().getTime();
        Date year = Calendar.getInstance().getTime();
        try {
            releaseDate = sdf.parse("1997-07-21");
            airDate = sdf.parse("1993-12-01");
            year = sdf.parse("1994-12-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Series series = Series.builder().title("Szonja").description("Anita").airDate(new Date())
                .status(Status.RUNNING).genres(Collections.singletonList(Genre.HORROR)).build();
        Season season = Season.builder().title("Oli").description("Zoli").year(new Date()).serialNumber(1).build();
        Season season2 = Season.builder().title("Oli2").description("Zoli").year(new Date()).serialNumber(1).build();
        Season season3 = Season.builder().title("Oli3").description("Zoli").year(new Date()).serialNumber(1).build();
        Season season4 = Season.builder().title("Oli4").description("Zoli").year(new Date()).serialNumber(1).build();
        series.addSeason(season);
        season.setSeries(series);
        series.addSeason(season2);
        season2.setSeries(series);
        series.addSeason(season3);
        season3.setSeries(series);
        series.addSeason(season4);
        season4.setSeries(series);

        Episode episode = Episode.builder().title("Anita").description("1").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode2 = Episode.builder().title("Bela").description("2").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode3 = Episode.builder().title("Cigi").description("3").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode4 = Episode.builder().title("Dave").description("4").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode5 = Episode.builder().title("Eszik").description("5").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode6 = Episode.builder().title("Fal").description("6").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        episode.setSeason(season);
        season.addEpisode(episode);
        episode2.setSeason(season2);
        season2.addEpisode(episode2);
        episode3.setSeason(season2);
        season2.addEpisode(episode3);
        episode4.setSeason(season3);
        season3.addEpisode(episode4);
        episode5.setSeason(season3);
        season3.addEpisode(episode5);
        episode6.setSeason(season3);
        season3.addEpisode(episode6);


        Series series2 = Series.builder().title("Szonja2").description("Anita").airDate(new Date())
                .status(Status.RUNNING).genres(Arrays.asList(Genre.HORROR, Genre.PORNO)).build();
        Season season21 = Season.builder().title("Oli21").description("Zoli").year(new Date()).serialNumber(1).build();
        Season season22 = Season.builder().title("Oli22").description("Zoli").year(new Date()).serialNumber(1).build();
        Season season23 = Season.builder().title("Oli23").description("Zoli").year(new Date()).serialNumber(1).build();
        Season season24 = Season.builder().title("Oli24").description("Zoli").year(new Date()).serialNumber(1).build();
        series.addSeason(season21);
        season21.setSeries(series2);
        series.addSeason(season22);
        season22.setSeries(series2);
        series.addSeason(season23);
        season23.setSeries(series2);
        series.addSeason(season24);
        season24.setSeries(series2);

        Episode episode21 = Episode.builder().title("A2").description("1").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode22 = Episode.builder().title("B2").description("2").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode23 = Episode.builder().title("C2").description("3").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode24 = Episode.builder().title("D2").description("4").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode25 = Episode.builder().title("E2").description("5").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        Episode episode26 = Episode.builder().title("F2").description("6").releaseDate(new Date()).runtime(45).serialNumber(0).build();
        episode21.setSeason(season21);
        season21.addEpisode(episode21);
        episode22.setSeason(season22);
        season22.addEpisode(episode22);
        episode23.setSeason(season22);
        season22.addEpisode(episode23);
        episode24.setSeason(season23);
        season23.addEpisode(episode24);
        episode25.setSeason(season23);
        season23.addEpisode(episode25);
        episode26.setSeason(season23);
        season23.addEpisode(episode26);

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
        em.persist(series2);
        em.persist(season);
        em.persist(season2);
        em.persist(season3);
        em.persist(season4);
        em.persist(season21);
        em.persist(season22);
        em.persist(season23);
        em.persist(season24);
        em.persist(user);
        em.persist(episode21);
        em.persist(episode22);
        em.persist(episode23);
        em.persist(episode24);
        em.persist(episode25);
        em.persist(episode26);
        transaction.commit();
    }

}
