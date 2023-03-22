<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <title>部门列表</title>
    <script type="text/javascript">
        function deleteDept(deptId) {
            const res = confirm("确定删除？");
            if (res) {
                location.href = "${pageContext.request.contextPath}/admin/dept?operator=deleteById&id=" + deptId;
            }
        }
    </script>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;">
            <div style="float: left;">
                <input type="button" class="btn btn-primary btn" value="添加"
                       onclick="javascript:location.href='deptUpsert.jsp'"/>
            </div>
            <form action="${pageContext.request.contextPath}/admin/dept" method="post" role="form" class="form-inline"
                  style="float: right;margin-bottom: 10px;">
                <input type="hidden" name="operator" value="showList">
                <div class="form-group" style="margin-right: 20px;">
                    <label for="deptName" style="margin-right: 10px;">部门名称</label>
                    <input type="text" class="form-control" id="deptName" name="deptName" value="${deptName}" placeholder="请输入部门名称"/>
                </div>
                <input type="submit" class="btn btn-primary btn" value="查询"/>
            </form>
            <table class="table table-bordered" style="margin-top: 20px;">
                <thead>
                <tr>
                    <th style="width: 100px;">序号</th>
                    <th style="width: 100px;">部门名称</th>
                    <th>部门介绍</th>
                    <th>创建时间</th>
                    <th style="width: 200px;">操作</th>
                </tr>
                </thead>
                <tbody>
				<c:forEach items="${pageBean.dataList}" var="dept" varStatus="vs">
                <tr class="success">
                    <td>${vs.count}</td>
                    <td>${dept.name}</td>
                    <td>${dept.remark}</td>
                    <td>${dept.createTimeStr}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/dept?operator=selectById&id=${dept.id}&cmd=select" class="btn btn-primary btn">详情</a>
                        <a href="${pageContext.request.contextPath}/admin/dept?operator=selectById&id=${dept.id}&cmd=update" class="btn btn-primary btn">修改</a>
                        <a href="javascript:void(0);" onclick="deleteDept('${dept.id}');" class="btn btn-primary btn">删除</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <span>${pageBean.totalCount}条记录 共${pageBean.totalPage}页 当前第${pageBean.currentPage}页</span>
            <!-- 分页 -->
            <ul class="pagination" style="float: right;margin: 0;">
                <li>
                    <a href="${pageContext.request.contextPath}/admin/dept?operator=showList&deptName=${deptName}&page=1&size=4">首页</a>
                </li>
                <li ${pageBean.currentPage == 1? 'class="disabled"' : ''}><a href="${pageContext.request.contextPath}/admin/dept?operator=showList&deptName=${deptName}&page=${pageBean.currentPage == 1 ? 1 : pageBean.currentPage - 1}&size=4">上一页</a></li>
                <li ${pageBean.currentPage == pageBean.totalPage? 'class="disabled"' : ''}><a href="${pageContext.request.contextPath}/admin/dept?operator=showList&deptName=${deptName}&page=${pageBean.currentPage == pageBean.totalPage ? pageBean.totalPage : pageBean.currentPage + 1}&size=4">下一页</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/dept?operator=showList&deptName=${deptName}&page=${pageBean.totalPage}&size=4">尾页</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</html>