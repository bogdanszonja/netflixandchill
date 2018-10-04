package com.codecool.netflixandchill.controller;

import com.codecool.netflixandchill.config.TemplateEngineUtil;
import com.codecool.netflixandchill.dao.implementation.UserDaoDB;
import com.codecool.netflixandchill.model.Episode;
import com.codecool.netflixandchill.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    private UserDaoDB userDaoDB = UserDaoDB.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        engine.process("register.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("register_username");
        String email = request.getParameter("register_email");
        String password = request.getParameter("register_password");
        String confirmedPassword = request.getParameter("password_confirm");

        if (userDaoDB.confirmPassword(password, confirmedPassword)) {
            userDaoDB.add(User.builder().userName(userName).emailAddress(email).password(password).build());
            response.sendRedirect("/login");
        }

        response.sendRedirect("/register");
    }

}

