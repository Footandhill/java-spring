
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script>
        var userList = new Array();
        userList.push({username:"dsad",age:12});
        userList.push({username:"adsa",age:18});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/quick12",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=UTF-8"
        });

    </script>
</head>
<body>

</body>
</html>
