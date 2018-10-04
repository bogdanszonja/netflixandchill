package com.codecool.netflixandchill.controller;

import com.codecool.netflixandchill.config.TemplateEngineUtil;
import com.codecool.netflixandchill.dao.EpisodeDao;
import com.codecool.netflixandchill.dao.SeriesDao;
import com.codecool.netflixandchill.dao.UserDao;
import com.codecool.netflixandchill.dao.implementation.EpisodeDaoDB;
import com.codecool.netflixandchill.dao.implementation.SeriesDaoDB;
import com.codecool.netflixandchill.dao.implementation.UserDaoDB;
import com.codecool.netflixandchill.model.Episode;
import com.codecool.netflixandchill.model.Series;
import com.codecool.netflixandchill.util.SessionManager;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/search"})
public class SearchPageController extends HttpServlet {
    private SessionManager sessionManager = SessionManager.getInstance();
    private EpisodeDao episodeDao = EpisodeDaoDB.getInstance();
    private UserDao userDao = UserDaoDB.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        HttpSession session = sessionManager.getHttpSession(request);

        if (session != null) context.setVariable("userId", session.getAttribute("userId"));

        String searchWord = request.getParameter("search");
        System.out.println(searchWord);

        List<Series> searchedEpisodes=SeriesDaoDB.getInstance().findBySubstring(searchWord);
        context.setVariable("episodes", searchedEpisodes);
        searchedEpisodes.forEach(System.out::print);

        engine.process("search.html", context, response.getWriter());

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

        String searchWord = request.getParameter("search");

        List<Episode> searchedEpisodes= episodeDao.findBySubstring(searchWord);
        context.setVariable("series", searchedEpisodes);

        engine.process("search.html", context, response.getWriter());
    }

}
