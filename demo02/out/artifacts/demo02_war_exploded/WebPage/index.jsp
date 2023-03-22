<%--
  Created by IntelliJ IDEA.
  User: Gordon
  Date: 2022/5/23
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    // 重定向到登录页面
    response.sendRedirect(request.getContextPath() + "/login.jsp");
%>
</body>
</html>
