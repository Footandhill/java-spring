<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <style type="text/css">
        .myDiv {
            width: 336px;
            height: 290px;
            margin-top: 288px;
            margin-left: 616px;
            position: absolute;
            border-radius: 5px;
        }

        .inputText {
            border: 0px;
            border-bottom: 1px solid #8ad2a3;
            font-size: 18px;
            line-height: 50px;
            width: 100%;
            outline: none;
        }

        .inputBtn {
            margin-top: 30px;
            font-size: 24px;
            -moz-box-shadow: 0px 20px 30px #4de5a4; /* 老的 Firefox */
            box-shadow: 0px 20px 30px #4de5a4;
            background: linear-gradient(to right, #4de5a4, #15a54d);
        }
    </style>
</head>
<body style="background: url('img/login.png') no-repeat;">
<div class="myDiv">
    <form id="login_form" method="post" action="${pageContext.request.contextPath}/loginAndLogout">
		<%--不用于显示界面，只是在提交表单的时候，携带过去的参数，使用隐藏表单--%>
		<input type="hidden" name="operator" value="login">
        <input type="text" class="inputText" name="username" id="username" placeholder="请输入账号" autofocus value="zhangsan"
               style="margin-top: 30px;"/><br>
		<span id="login_msg" style="color: red;">${error_msg}</span>
        <input type="password" class="inputText" name="password" id="password" placeholder="请输入密码" value="111111"
               style="margin-top: 60px;"/><br>
        <input type="submit" class="btn btn-success btn-lg btn-block inputBtn" value="登录"/>
    </form>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function () {
		// 给登录表单绑定提交事件
		$("#login_form").submit(function () {
			// 1.获取输入的用户名
			const username = $("#username").val();
			const password = $("#password").val();
			// 2.前端判断
			if (username.trim().length == 0) {
				$("#login_msg").text("用户名不能为空！");
				return false;
			}
			if (password.trim().length == 0) {
				$("#login_msg").text("密码不能为空！");
				return false;
			}
			return true;
		});
	});
</script>

</html>