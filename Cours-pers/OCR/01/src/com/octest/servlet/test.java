package com.octest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

public class test extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String msg = "Au revoir !";

        // Transmission d'une variable/information à notre JSP
        request.setAttribute("variable", msg);
        request.setAttribute("heure", "jour");

        // .forward transmet la request et la response à notre JSP
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println("Bonjour");
    }
}
