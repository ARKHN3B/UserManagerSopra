<%--
  Created by IntelliJ IDEA.
  User: benlmsc
  Date: 2019-03-06
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <p>${ !empty msg ? msg : '' }</p>
    <form action="" method="post">
        <fieldset style="width: fit-content;">
            <legend>Calculator</legend>
            <input type="text" name="number1">
            <select name="mark" id="">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
                <option value="%">%</option>
            </select>
            <input type="text" name="number2">
            <button type="submit">Calculate</button>
        </fieldset>
    </form>
</body>
</html>
