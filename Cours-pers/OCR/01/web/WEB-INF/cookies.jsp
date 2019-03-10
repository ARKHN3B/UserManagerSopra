<%--
  Created by IntelliJ IDEA.
  User: benlmsc
  Date: 2019-03-07
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Cookies</title>
</head>
<body>
    <p>${ firstname }</p>
    <form action="cookies" method="post">
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
