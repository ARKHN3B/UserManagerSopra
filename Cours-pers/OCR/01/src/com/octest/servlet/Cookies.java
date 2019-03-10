package com.octest.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookies")
public class Cookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        // Pour stocker un cookie
        // Par défaut le cookie a un temps égal à celui de la session
        // De plus, le cookie JSESSIONID est utilisé par JAVAEE afin d'identifier l'utilisateur tout au long de sa session
        Cookie cookie = new Cookie("firstname", firstname);
        // Âge exprimé en seconde. e.g. 60 * 60 va expiré dans une heure
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

        request.getRequestDispatcher("/WEB-INF/cookies.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // On recupère tous nos cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if ( cookie.getName().equals("firstname") ) {
                    request.setAttribute("firstname", cookie.getValue());
                }
            }
        }

        request.getRequestDispatcher("/WEB-INF/cookies.jsp").forward(request, response);
    }
}
