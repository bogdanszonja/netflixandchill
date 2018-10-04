package com.codecool.netflixandchill.controller;

import com.codecool.netflixandchill.config.TemplateEngineUtil;
import com.codecool.netflixandchill.dao.SeriesDao;
import com.codecool.netflixandchill.dao.implementation.SeriesDaoDB;
import com.codecool.netflixandchill.model.Series;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/search"})
public class SearchPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        String searchWord = request.getParameter("search");

        SeriesDao seriesDao = SeriesDaoDB.getInstance();
        List<Series> searchedSeries = seriesDao.findBySubstring(searchWord);

        engine.process("search.html", context, response.getWriter());

    }

}
