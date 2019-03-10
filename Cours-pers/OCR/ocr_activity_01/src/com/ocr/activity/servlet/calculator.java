package com.ocr.activity.servlet;

import com.ocr.activity.utils.Utils;
import com.sun.jdi.DoubleValue;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class calculator extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // Get params from url
        Map<String, String[]> params = request.getParameterMap();

        double number1 = 0;
        double number2 = 0;

        for(Map.Entry<String, String[]> entry: params.entrySet()) {
            String key = entry.getKey();
            // Get the current value
            String value = entry.getValue()[0];

            switch (key) {
                case "number1":
                    number1 = Utils.isNumeric(value) ? Double.parseDouble(value) : 0;
                    break;
                case "number2":
                    number2 = Utils.isNumeric(value) ? Double.parseDouble(value) : 0;
                    break;
            }
        }

        Double result = this.calculate(params.get("mark")[0].charAt(0), number1, number2);
        String msg = "Résultat de l'opération : " + number1 + " + " + number2 + " = " + result;

        request.setAttribute("msg", msg);

        this.getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
    }

    /**
     * Calculate between two number
     * @param mark
     * @param nbr1
     * @param nbr2
     * @return
     */
    private Double calculate(char mark, Double nbr1, Double nbr2) {
        Double total;
        switch (mark) {
            case '+':
                total = nbr1 + nbr2;
                break;
            case '-':
                total = nbr1 - nbr2;
                break;
            case '*':
                total = nbr1 * nbr2;
                break;
            case '/':
                total = nbr1 / nbr2;
                break;
            case '%':
                total = nbr1 % nbr2;
                break;
            default:
                total = null;
                break;
        }
        return total;
    }
}
