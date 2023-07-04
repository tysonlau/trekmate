package com.hike.demo.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hike.demo.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private List<User> users = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = findUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            response.getWriter().println("Welcome, " + user.getName() + "!");
        } else {
            // Failed login
            response.getWriter().println("Invalid username or password.");
        }
    }

    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }
}

