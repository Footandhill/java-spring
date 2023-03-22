<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <title>商品列表</title>
</head>

<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;">
            <div style="float: left;">
                <input type="button" class="btn btn-primary btn" value="添加"
                       onclick="javascript:location.href='${pageContext.request.contextPath}/admin/shopping?operator=initShopping'"/>
            </div>
            <form action="${pageContext.request.contextPath}/admin/shopping" method="post" id="userForm" role="form" class="form-inline"
                  style="float: right;margin-bottom: 10px;">
                <input type="hidden" value="showList" name="operator">
                <input type="hidden" value="1" name="page">
                <input type="hidden" value="8" name="size">
                <div class="form-group" style="margin-right: 20px;">
                    <label for="name" style="margin-right: 10px;">名称</label>
                    <input type="text" class="form-control" id="name"  name="name" value="${name}" placeholder="商品名称"/>
                </div>

                <div class="form-group" style="margin-right: 20px;">
                    <label for="companyId" style="margin-right: 10px;">公司</label>
                    <select class="form-control" name="companyId" id="companyId">
                        <option value="">请选择供应商</option>
                        <c:forEach items="${companyList}" var="company">
                            <option value="${company.id}" ${companyId == company.id ? "selected" : ""} >${company.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group" style="margin-right: 20px;">
                    <label for="typeId" style="margin-right: 10px;">类别</label>
                    <select class="form-control" name="typeId" id="typeId">
                        <option value="">请选择类别</option>
                        <c:forEach items="${typeList}" var="type">
                            <option value="${type.id}" ${typeId == type.id ? "selected" : ""} >${type.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group" style="margin-right: 20px;">
                    <label for="priceType" style="margin-right: 10px;">价格</label>
                    <select class="form-control" name="priceType" id="priceType">
                        <option value="">请选择价格类别</option>
                        <option value="in_price" ${priceType == "in_price" ? "selected" : ""}>售价</option>
                        <option value="out_price" ${priceType == "out_price" ? "selected" : ""}>进价</option>
                        <option value="out_price-in_price" ${priceType == "out_price-in_price" ? "selected" : ""}>利润</option>
                    </select>
                </div>
                <div class="form-group" style="margin-right: 20px;">
                    <label style="margin-right: 10px;">排序</label>
                    <input type="radio" class="form-control"  name="orderBy" value="asc" ${orderBy == "asc" ? "checked" : ""}/>升序
                    <input type="radio" class="form-control"  name="orderBy" value="desc" ${orderBy == "desc" ? "checked" : ""}/>降序
                    <input type="radio" class="form-control"  name="orderBy" value="" ${empty orderBy ? "checked" : ""}/>默认
                </div>
                <input type="submit" class="btn btn-primary btn" value="查询"/>
            </form>
            <table class="table table-bordered" style="margin-top: 20px;">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>商品名称</th>
                    <th>数量</th>
                    <th>进价</th>
                    <th>售价</th>
                    <th>利润</th>
                    <th>供应商</th>
                    <th>类别</th>
                    <th style="width: 200px;">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageBean.dataList}" var="shopping" varStatus="vs">
                    <tr class="success">
                        <td>${vs.count}</td>
                        <td>${shopping.name}</td>
                        <td>${shopping.number}</td>
                        <td>${shopping.inPrice}</td>
                        <td>${shopping.outPrice}</td>
                        <td>${shopping.outPrice - shopping.inPrice}</td>
                        <td>${shopping.company.name}</td>
                        <td>${shopping.type.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/shopping?operator=selectById&id=${shopping.id}&cmd=select" class="btn btn-primary btn">详情</a>
                            <a href="${pageContext.request.contextPath}/admin/shopping?operator=selectById&id=${shopping.id}&cmd=update" class="btn btn-primary btn">修改</a>
                            <a href="javascript:void(0);" onclick="deleteShopping('${shopping.id}')" class="btn btn-primary btn">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <span>${pageBean.totalCount}条记录 共${pageBean.totalPage}页 当前第${pageBean.currentPage}页</span>
            <!-- 分页 -->
            <ul class="pagination" style="float: right;margin: 0;">
                <li>
                    <a href="${pageContext.request.contextPath}/admin/shopping?operator=showList&name=${name}&companyId=${companyId}&typeId=${typeId}&priceType=${priceType}&orderBy=${orderBy}&page=1&size=8">首页</a>
                </li>
                <li ${pageBean.currentPage == 1? 'class="disabled"' : ''}><a href="${pageContext.request.contextPath}/admin/shopping?operator=showList&name=${name}&companyId=${companyId}&typeId=${typeId}&priceType=${priceType}&orderBy=${orderBy}&page=${pageBean.currentPage == 1 ? 1 : pageBean.currentPage - 1}&size=8">上一页</a></li>
                <li ${pageBean.currentPage == pageBean.totalPage? 'class="disabled"' : ''}><a href="${pageContext.request.contextPath}/admin/shopping?operator=showList&name=${name}&companyId=${companyId}&typeId=${typeId}&priceType=${priceType}&orderBy=${orderBy}&page=${pageBean.currentPage == pageBean.totalPage ? pageBean.totalPage : pageBean.currentPage + 1}&size=8">下一页</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/shopping?operator=showList&name=${name}&companyId=${companyId}&typeId=${typeId}&priceType=${priceType}&orderBy=${orderBy}&page=${pageBean.totalPage}&size=8">尾页</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
    function deleteShopping(shoppingId) {
        if (confirm("确定删除吗？")) {
            location.href = "${pageContext.request.contextPath}/admin/shopping?operator=deleteById&id=" + shoppingId;
        }
    }
</script>

</html>