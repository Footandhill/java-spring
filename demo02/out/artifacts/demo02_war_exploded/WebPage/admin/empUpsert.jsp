<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"/>
    <style type="text/css">
        .inputText {
            width: 430px !important;
        }

        .rowDiv {
            margin-bottom: 15px;
        }

        .form-lavel {
            width: 80px;
            text-align: right;
        }
    </style>
    <title>员工信息</title>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;padding-top: 0px;">
            <form action="${pageContext.request.contextPath}/admin/emp" method="post" id="empForm" role="form"
                  class="form-inline" style="margin-bottom: 10px;">
                <input type="hidden" name="operator" value="upsertEmp">
                <input type="hidden" name="id" value="${emp.id}">
                <div class="form" style="padding:5px;">
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="id">ID：</label>
                                <input type="text" disabled class="form-control inputText" id="id" name="id"
                                       value="${emp.id}" placeholder="员工id">
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="name">姓名：</label>
                                <input type="text" class="form-control inputText"
                                       id="name" ${cmd == "select" ? "disabled" : ""} value="${emp.name}" name="name"
                                       placeholder="姓名">
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="username">用户名：</label>
                                <input type="text" class="form-control inputText"
                                       name="username" ${cmd == "select" ? "disabled" : ""} value="${emp.username}"
                                       id="username"
                                       placeholder="用户名">
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel">性别：</label>
                                <input type="radio" name="gender" value="男" ${cmd == "select" ? "disabled" : ""} ${emp.gender == "男" ? "checked" : ""}>男&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="gender" value="女" ${cmd == "select" ? "disabled" : ""} ${emp.gender == "女" ? "checked" : ""}>女&nbsp;&nbsp;&nbsp;&nbsp;
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="telphone">手机号：</label>
                                <input type="text" class="form-control inputText"
                                       id="telphone" ${cmd == "select" ? "disabled" : ""} value="${emp.telphone}"
                                       name="telphone"
                                       placeholder="手机号">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="address">地址：</label>
                                <input type="text" class="form-control inputText"
                                       id="address" ${cmd == "select" ? "disabled" : ""} name="address"
                                       value="${emp.address}"
                                       placeholder="居住地址">
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="birthday">生日：</label>
                                <input type="date" class="form-control inputText"
                                       id="birthday" ${cmd == "select" ? "disabled" : ""} value="${emp.birthday}"
                                       name="birthdayStr">
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="hiredate">入职日期：</label>
                                <input type="date" class="form-control inputText"
                                       id="hiredate" ${cmd == "select" ? "disabled" : ""} value="${emp.hiredate}"
                                       name="hiredateStr">
                            </div>
                        </div>

                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="deptId">部门：</label>
                                <select class="form-control" id="deptId"
                                        name="deptId" ${cmd == "select" ? "disabled" : ""}>
                                    <c:forEach items="${deptList}" var="dept">
                                        <option value="${dept.id}" ${emp.deptId == dept.id ? "selected" : ""}>${dept.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="roleId">角色：</label>
                                <select class="form-control" id="roleId"
                                        name="roleId" ${cmd == "select" ? "disabled" : ""}>
                                    <c:forEach items="${roleList}" var="role">
                                        <option value="${role.id}" ${emp.roleId == role.id ? "selected" : ""}>${role.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="remark">其他：</label>
                                <textarea cols="50" rows="3" name="remark"
                                          id="remark" ${cmd == "select" ? "disabled" : ""}>${emp.remark}</textarea>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <c:if test="${cmd == 'select'}">
                                <div class="form-group">
                                    <input type="button" class="btn btn-primary btn-sm" value="返回" onclick="javascript:location.href='${pageContext.request.contextPath}/admin/emp?operator=showList&page=1&size=4'"/>
                                </div>
                            </c:if>
                            <c:if test="${cmd != 'select'}">
                                <div class="form-group">
                                    <input type="submit" class="btn btn-primary btn-sm" value="提交"/>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</html>