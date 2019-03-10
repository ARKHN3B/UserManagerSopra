<%--
  Created by IntelliJ IDEA.
  User: benlmsc
  Date: 2019-03-07
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Formulaire</title>
</head>
<body>
    <c:if test="${ !empty signin.resultat }">
        <p><c:out value="${ signin.resultat }"/></p>
    </c:if>
    <form action="form" method="post">
        <fieldset>
            <legend>Formulaire</legend>
            <span>
                 <label for="login">Login :</label><input type="text" name="login" id="login">
            </span>
            <span>
                 <label for="password">Password :</label><input type="password" name="password" id="password">
            </span>
            <input type="submit">
        </fieldset>
    </form>
</body>
</html>
