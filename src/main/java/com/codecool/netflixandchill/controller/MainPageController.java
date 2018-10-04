package com.codecool.netflixandchill.controller;

import com.codecool.netflixandchill.config.TemplateEngineUtil;
import com.codecool.netflixandchill.dao.implementation.EpisodeDaoDB;
import com.codecool.netflixandchill.model.*;
import com.codecool.netflixandchill.util.EMFManager;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private EpisodeDaoDB episodeDaoDB = EpisodeDaoDB.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        if (firstVisit) {
            this.populateDb();
            Episode episode = Episode.builder().title("b").description("dasdasd").releaseDate(new Date()).runtime(45).serialNumber(0).build();
            episodeDaoDB.add(episode);
            firstVisit = false;
            System.out.println("pina");
        }

        System.out.println("nopina");
        context.setVariable("episodes", episodeDaoDB.getAll());

        engine.process("index.html", context, response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        //response.getWriter().write(Integer.toString(numOfProducts));
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

}
