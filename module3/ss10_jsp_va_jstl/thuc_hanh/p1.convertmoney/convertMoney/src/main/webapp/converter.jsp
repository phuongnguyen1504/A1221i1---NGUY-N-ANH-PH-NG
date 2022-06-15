<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 15/06/2022
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<%
  Float rate=Float.parseFloat(request.getParameter("rate"));
  Float usd=Float.parseFloat(request.getParameter("usd"));
  Float vnd=rate*usd;
%>
<h1>Rate:<%=rate%></h1>
<h1>USD:<%=usd%></h1>
<h1>VND:<%=vnd%></h1>
</body>
</html>
