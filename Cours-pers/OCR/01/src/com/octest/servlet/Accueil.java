package com.octest.servlet;

import com.octest.bean.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Accueil")
public class Accueil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Author author = new Author();
        author.setFirstname("Benjamin");
        author.setLastname("Lemullois");
        author.setActive(true);

        // Get a param from the url
        String name = request.getParameter("name");
        String[] names = {"Jean", "Ben", "Abraham"};

        request.setAttribute("name", name);
        request.setAttribute("names", names);
        request.setAttribute("author", author);

        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }
}
