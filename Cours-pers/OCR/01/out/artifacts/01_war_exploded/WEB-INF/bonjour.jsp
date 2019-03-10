<%--
  Created by IntelliJ IDEA.
  User: benlmsc
  Date: 2019-03-06
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>OCTest - Bonjour</title>
</head>
<body>
    <%@include file="menu.jsp"%>
    <p>
        <%
            String heure = (String) request.getAttribute("heure");

            if (heure.equals("jour")) {
                out.print("Bonjour");
            }
            else {
                out.print("Bonsoir");
            }
        %>
        à vous !
    </p>
    <p>
        <%-- Ajout d'une variable provenant d'une servlet et affichage de la variable de type string --%>
        <%
            String var = (String) request.getAttribute("variable");
            out.println(var);
        %>
    </p>
    <p>
        <%
            for (int i = 0; i < 20 ; i++) {
                out.println("Une nouvelle ligne ! </br>");
            }
        %>
    </p>
</body>
</html>
