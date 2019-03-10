<%--
  Created by IntelliJ IDEA.
  User: benlmsc
  Date: 2019-03-07
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Send a file</title>
</head>
<body>
    <c:choose>
        <c:when test="${ !empty file }">
            <p>Le fichier <c:out value="${ file }"/> (<c:out value="${ description }"/>) a bien été uploadé !</p>
        </c:when>
    </c:choose>
    <form action="send-file" method="post" enctype="multipart/form-data">
        <div>
            <label for="description">Description :</label><input type="text" name="description" id="description">
        </div>
        <div>
            <%-- Pour envoyer un fichier, il est important de préciser certaines informations dans le fichier config : web.xml --%>
            <label for="file">Fichier à envoyer :</label><input type="file" name="file" id="file">
        </div>
        <input type="submit">
    </form>
</body>
</html>
