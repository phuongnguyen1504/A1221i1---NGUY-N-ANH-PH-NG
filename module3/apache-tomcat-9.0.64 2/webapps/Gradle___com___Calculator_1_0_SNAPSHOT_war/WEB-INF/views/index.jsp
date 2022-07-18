<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 18/07/2022
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculate" method="post">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <input type="submit" name="operator" value="+">
    <input type="submit" name="operator" value="-">
    <input type="submit" name="operator" value="*">
    <input type="submit" name="operator" value="/">
</form>


<h2>Result: ${result}</h2>
</body>
</html>
