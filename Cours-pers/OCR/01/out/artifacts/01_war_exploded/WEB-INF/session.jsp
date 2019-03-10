<%--
  Created by IntelliJ IDEA.
  User: benlmsc
  Date: 2019-03-07
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Session</title>
</head>
<body>
    <c:if test="${ !empty sessionScope.firstname && !empty sessionScope.lastname}">
        <p>Vous êtes ${ sessionScope.firstname} ${sessionScope.lastname}</p>
    </c:if>
    <form action="session" method="post">
        <div>
            <label for="firstname">Firstname : </label><input type="text" name="firstname" id="firstname">
        </div>
        <div>
            <label for="lastname">Lastname : </label><input type="text" name="lastname" id="lastname">
        </div>
        <input type="submit">
    </form>
</body>
</html>
