package com.octest.servlet;

import com.octest.form.Signin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Form")
public class Form extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Signin signin = new Signin();
        signin.verifyId(request);

        request.setAttribute("signin", signin);
        request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
    }
}
