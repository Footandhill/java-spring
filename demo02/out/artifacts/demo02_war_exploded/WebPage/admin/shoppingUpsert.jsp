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
    <title>商品信息</title>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;padding-top: 0px;">
            <form action="${pageContext.request.contextPath}/admin/shopping?operator=upsertShopping" enctype="multipart/form-data" method="post" id="shoppingForm" role="form"
                  class="form-inline" style="margin-bottom: 10px;">
                <input type="hidden" name="operator" value="upsertShopping">
                <input type="hidden" name="id" value="${shopping.id}">
                <div class="form" style="padding:5px;">
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="id">ID：</label>
                                <input type="text" disabled class="form-control inputText" id="id" name="id"
                                       value="${shopping.id}" placeholder="商品id">
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">

                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="name">名称：</label>
                                <input type="text" class="form-control inputText"
                                       id="name" ${cmd == "select" ? "disabled" : ""} value="${shopping.name}"
                                       name="name"
                                       placeholder="商品名称">
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="number">数量：</label>
                                <input type="number" class="form-control inputText"
                                       name="number" ${cmd == "select" ? "disabled" : ""} value="${shopping.number}"
                                       id="number"
                                       placeholder="数量">
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">

                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="inPrice">进价：</label>
                                <input type="text" class="form-control inputText"
                                       name="inPrice" ${cmd == "select" ? "disabled" : ""} value="${shopping.inPrice}"
                                       id="inPrice"
                                       placeholder="进价">
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="outPrice">售价：</label>
                                <input type="text" class="form-control inputText"
                                       name="outPrice" ${cmd == "select" ? "disabled" : ""} value="${shopping.outPrice}"
                                       id="outPrice"
                                       placeholder="售价">
                                <span style="color: red;">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row rowDiv">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="typeId">类别：</label>
                                <select class="form-control" id="typeId"
                                        name="typeId" ${cmd == "select" ? "disabled" : ""}>
                                    <c:forEach items="${typeList}" var="type">
                                        <option value="${type.id}" ${shopping.typeId == type.id ? "selected" : ""}>${type.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="companyId">供应商：</label>
                                <select class="form-control" id="companyId"
                                        name="companyId" ${cmd == "select" ? "disabled" : ""}>
                                    <c:forEach items="${companyList}" var="company">
                                        <option value="${company.id}" ${shopping.companyId == company.id ? "selected" : ""}>${company.name}</option>
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
                                          id="remark" ${cmd == "select" ? "disabled" : ""}>${shopping.remark}</textarea>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="form-lavel" for="image">图像：</label>
                                <c:if test="${cmd == 'select' or cmd == 'update'}">
                                    <img width="100px" height="100px"
                                         src="${pageContext.request.contextPath}/${shopping.image}"/>
                                </c:if>
                                <c:if test="${cmd != 'select'}">
                                    <input type="file" class="form-control" name="image" id="image"/>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <c:if test="${cmd == 'select'}">
                                <div class="form-group">
                                    <input type="button" class="btn btn-primary btn-sm" value="返回"
                                           onclick="javascript:location.href='${pageContext.request.contextPath}/admin/shopping?operator=showList&page=1&size=4'"/>
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