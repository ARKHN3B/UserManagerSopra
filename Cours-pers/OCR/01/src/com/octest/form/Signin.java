package com.octest.form;

import javax.servlet.http.HttpServletRequest;

public class Signin {
    private String resultat;

    public void verifyId(HttpServletRequest req) {
        String login    = req.getParameter("login");
        String password = req.getParameter("password");

        if (password.equals(login + 123)) {
            resultat = "Vous êtes bien connecté";
        }
        else resultat = "Identifiants incorrects";

        setResultat(resultat);
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
