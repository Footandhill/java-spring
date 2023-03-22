<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <title>员工列表</title>
</head>

<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;">
            <div style="float: left;">
                <input type="button" class="btn btn-primary btn" value="添加"
                       onclick="javascript:location.href='${pageContext.request.contextPath}/admin/emp?operator=initEmp'"/>
            </div>
            <form action="${pageContext.request.contextPath}/admin/emp" method="post" id="userForm" role="form" class="form-inline"
                  style="float: right;margin-bottom: 10px;">
                <input type="hidden" value="showList" name="operator">
                <input type="hidden" value="1" name="page">
                <input type="hidden" value="4" name="size">
                <div class="form-group" style="margin-right: 20px;">
                    <label for="name" style="margin-right: 10px;">姓名</label>
                    <input type="text" class="form-control" id="name"  name="name" value="${name}" placeholder="姓名"/>
                </div>

                <div class="form-group" style="margin-right: 20px;">
                    <label for="deptId" style="margin-right: 10px;">部门</label>
                    <select class="form-control" name="deptId" id="deptId">
                        <option value="">请选择部门</option>
                        <c:forEach items="${deptList}" var="dept">
                            <option value="${dept.id}" ${deptId == dept.id ? "selected" : ""} >${dept.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group" style="margin-right: 20px;">
                    <label for="deptId" style="margin-right: 10px;">角色</label>
                    <select class="form-control" name="roleId" id="roleId">
                        <option value="">请选择角色</option>
                        <%--JSTL遍历HashMap--%>
                        <c:forEach items="${roleMap}" var="item">
                            <option value="${item.key}" ${roleId == item.key ? "selected" : ""} >${item.value.name}</option>
                        </c:forEach>
                    </select>
                    <%--<select class="form-control" name="roleId" id="roleId">
                        <option value="">请选择角色</option>
                        <c:forEach items="${roleList}" var="role">
                            <option value="${role.id}" ${roleId == role.id ? "selected" : ""} >${role.name}</option>
                        </c:forEach>
                    </select>--%>
                </div>
                <input type="submit" class="btn btn-primary btn" value="查询"/>
            </form>
            <table class="table table-bordered" style="margin-top: 20px;">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>出生日期</th>
                    <th>手机号</th>
                    <th>地址</th>
                    <th>入职日期</th>
                    <th>其他信息</th>
                    <th>角色</th>
                    <th>部门</th>
                    <th style="width: 200px;">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageBean.dataList}" var="emp" varStatus="vs">
                    <tr class="success">
                        <td>${vs.count}</td>
                        <td>${emp.name}</td>
                        <td>${emp.gender}</td>
                        <td>${emp.birthday}</td>
                        <td>${emp.telphone}</td>
                        <td>${emp.address}</td>
                        <td>${emp.hiredate}</td>
                        <td>${emp.remark}</td>
                        <td>${emp.role.name}</td>
                        <td>${emp.dept.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/emp?operator=selectById&id=${emp.id}&cmd=select" class="btn btn-primary btn">详情</a>
                            <a href="${pageContext.request.contextPath}/admin/emp?operator=selectById&id=${emp.id}&cmd=update" class="btn btn-primary btn">修改</a>
                            <a href="javascript:void(0);" onclick="deleteEmp('${emp.id}')" class="btn btn-primary btn">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <span>${pageBean.totalCount}条记录 共${pageBean.totalPage}页 当前第${pageBean.currentPage}页</span>
            <!-- 分页 -->
            <ul class="pagination" style="float: right;margin: 0;">
                <li>
                    <a href="${pageContext.request.contextPath}/admin/emp?operator=showList&name=${name}&deptId=${deptId}&roleId=${roleId}&page=1&size=4">首页</a>
                </li>
                <li ${pageBean.currentPage == 1? 'class="disabled"' : ''}><a href="${pageContext.request.contextPath}/admin/emp?operator=showList&name=${name}&deptId=${deptId}&roleId=${roleId}&page=${pageBean.currentPage == 1 ? 1 : pageBean.currentPage - 1}&size=4">上一页</a></li>
                <li ${pageBean.currentPage == pageBean.totalPage? 'class="disabled"' : ''}><a href="${pageContext.request.contextPath}/admin/emp?operator=showList&name=${name}&deptId=${deptId}&roleId=${roleId}&page=${pageBean.currentPage == pageBean.totalPage ? pageBean.totalPage : pageBean.currentPage + 1}&size=4">下一页</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/emp?operator=showList&name=${name}&deptId=${deptId}&roleId=${roleId}&page=${pageBean.totalPage}&size=4">尾页</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
    function deleteEmp(empId) {
        if (confirm("确定删除吗？")) {
            location.href = "${pageContext.request.contextPath}/admin/emp?operator=deleteById&id=" + empId;
        }
    }
</script>

</html>