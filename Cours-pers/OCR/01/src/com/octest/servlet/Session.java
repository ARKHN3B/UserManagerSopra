package com.octest.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Session")
public class Session extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        // Initialisation du moteur de session de J2EE avec request.getSession()
        HttpSession session = request.getSession();

        session.setAttribute("firstname", firstname);
        session.setAttribute("lastname", lastname );

        request.getRequestDispatcher("/WEB-INF/session.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String firstname = (String) session.getAttribute("firstname");
        String lastname = (String) session.getAttribute("firstname");

        if (firstname != null && lastname != null) {
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
        }

        // Désactiver la session
        // session.invalidate();

        request.getRequestDispatcher("/WEB-INF/session.jsp").forward(request, response);
    }
}
