<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--1s刷新一次--%>
<%--<meta http-equiv="refresh" content="1">--%>
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<style type="text/css">
	.btn_a {
		width: 88px;
		line-height: 30px;
		font-size: 16px;
		background: #fff;
		color: #15a547;
		border: 1px solid #15a547;
		border-radius: 25px;
	}
	.btn_a:HOVER {
		background: #15a547;
		color: #fff;
		-moz-box-shadow: 1px 1px 1px #fff; /* 老的 Firefox */
		box-shadow: 1px 1px 1px #fff;
		border: 1px solid #fff;
	}
</style>
</head>
<body style="background: url('../../img/title.png') no-repeat;overflow: hidden;">
	<div style="width: 100%;text-align: right;line-height: 74px;padding-right: 20px;color: #FFFFFF;">
		<span style="color: #32394d;font-size: 18px;"><strong>${emp.name}</strong>你好，今天是<strong id="date"></strong></span>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="password.jsp" class="btn btn-sm btn_a" target="content">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="btn btn-sm btn_a" onclick="logout()">退出</a>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function logout() {
		const res = confirm("确定退出吗？");
		if (res) {
			// 打开新的地址，访问servlet
			window.open("${pageContext.request.contextPath}/loginAndLogout?operator=logout", "_top");
		}
	}
	// 页面加载完毕执行的函数
	$(function () {
		showTime();
		setInterval("showTime()", 1000);
	});

	// 定义一个函数
	function showTime() {
		// 得到当前日期
		const date = new Date();
		// 将date对象转成字符串并显示到<strong id="date"></strong>内
		$("#date").text(date.toLocaleString());
	}

</script>

</html>