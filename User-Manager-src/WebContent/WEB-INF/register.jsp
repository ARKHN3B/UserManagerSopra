<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Formulaire</title>
	<link type="text/css" rel="stylesheet" href="./styles.css">
</head>
<body>
	<c:import url="/WEB-INF/menu/menu.jsp" />
	<c:import url="/WEB-INF/User/form.jsp" />
	<br />
	<c:if test="${ errorStatus }">
	<c:import url="/WEB-INF/User/card.jsp" />
	</c:if>
</body>
</html>