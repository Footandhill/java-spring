<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css" />
</head>
<body>
	<div class="container-fluid" style="padding: 0;">
		<div class="row-fluid">
			<div class="col-md-12" style="padding: 0;">
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					<li>
						<a href="#systemSetting1" onclick="menuCss(this)" class="nav-header collapsed" data-toggle="collapse">
							<i class="glyphicon glyphicon-home"></i>
							<span style="display: inline-block;margin-left: 20px;">商品管理</span>
							<span class="pull-right glyphicon glyphicon-chevron-down"></span>
						</a>
						<ul id="systemSetting1" class="nav nav-list collapse secondmenu" style="height: 0px;">
							<li>
								<a href="${pageContext.request.contextPath}/admin/type?operator=showList&page=1&size=4" onclick="menuCss(this)" target="content" style="padding-left:25px;">类别管理</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/admin/shopping?operator=showList&page=1&size=8" onclick="menuCss(this)" target="content" style="padding-left:25px;">商品管理</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#systemSetting9" onclick="menuCss(this)" class="nav-header collapsed" data-toggle="collapse">
							<i class="glyphicon glyphicon-cog"></i>
							<span style="display: inline-block;margin-left: 20px;">系统管理</span>
							<span class="pull-right glyphicon glyphicon-chevron-down"></span>
						</a>
						<ul id="systemSetting9" class="nav nav-list collapse secondmenu" style="height: 0px;">
							<li>
								<a href="${pageContext.request.contextPath}/admin/dept?operator=showList&page=1&size=4" onclick="menuCss(this)" target="content" style="padding-left:25px;">部门管理</a>
							</li>
							<li>
								<%--需要依照部门相关操作流程，改写为角色相关操作--%>
								<a href="${pageContext.request.contextPath}/admin/role?operator=showList&page=1&size=4" onclick="menuCss(this)" target="content" style="padding-left:25px;">角色管理</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/admin/emp?operator=showList&page=1&size=4" onclick="menuCss(this)" target="content" style="padding-left:25px;">员工管理</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>
</html>