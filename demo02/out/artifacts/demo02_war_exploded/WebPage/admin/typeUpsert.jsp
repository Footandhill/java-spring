<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
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
    <title>类别信息</title>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;padding-top: 0px;">
            <form action="#" method="post" id="typeForm" role="form" class="form-inline" style="margin-bottom: 10px;">
                <div class="form" style="padding:5px;">
                    <div class="row rowDiv">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="form-lavel" for="typeId">ID：</label>
                                <input type="text" class="form-control inputText" id="typeId" name="typeId"
                                       value="${type.id}" disabled>
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="form-lavel" for="typeName">名称：</label>
                                <input type="text" class="form-control inputText" id="typeName" name="typeName"
                                       value="${type.name}"
                                ${cmd == "select" ? "disabled" : ""} placeholder="请输入类别名称">
                                <span style="color: red;" id="typeNameMsg">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="form-lavel" for="remark">介绍：</label>
                                <textarea id="remark" name="remark" placeholder="请输入类别介绍" ${cmd == "select" ? "disabled" : ""}
                                          cols="50">${type.remark}</textarea>
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <c:if test="${cmd == 'select'}">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input type="button" class="btn btn-primary btn-sm" value="返回" onclick="javascript:location.href='${pageContext.request.contextPath}/admin/type?operator=showList&page=1&size=4'"/>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${cmd != 'select'}">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input type="submit" class="btn btn-primary btn-sm" value="提交"/>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        // 给类别名称绑定事件
        $("#typeName").blur(function () {
            // 获取类别名称
            const typeName = $(this).val();
            // 判断是否为空
            if (typeName.trim().length === 0) {
                $("#typeNameMsg").text("类别名称不能为空");
                return;
            }
            // 使用异步请求调用：检查是否存在
            // 使用$.get()
            $.get("${pageContext.request.contextPath}/admin/type?operator=checkTypeName&typeName=" + typeName, function (res) {
                // 判断结果
                if (res == "true") {
                    $("#typeNameMsg").text("类别名称已存在");
                    return;
                }
                $("#typeNameMsg").text("类别名称可以使用");
                $("#typeNameMsg").css("color", "blue");
            });
        });

        // 提交前的校验
        $("#typeForm").submit(function () {
            const typeName = $("#typeName").val();
            const remark = $("#remark").val();
            // 判断是否为空
            if (typeName.trim().length == 0) {
                return false;
            }
            // 提交数据
            // 使用ajax()方法发送异步请求
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/type",
                type: "POST",
                data: {
                    operator: "updateType",
                    id: "${type.id}",
                    typeName: typeName,
                    remark: remark
                },
                async: true,
                dataType: "text",
                success: function (xhr, data) {
                    alert("成功：" + data);
                    location.href = "${pageContext.request.contextPath}/admin/type?operator=showList&page=1&size=4";
                },
                error: function (xhr, msg, err) {
                    console.log(msg, err);
                }
            });
            return false;
        });
    });
</script>
</html>