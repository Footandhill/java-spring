<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<style type="text/css">
.myDiv {
    width: 400px;
    height: 200px;
    border: 1px solid #5e5e5e;
    top: 50%;
    left: 50%;
    margin-top: -100px;
    margin-left: -150px;
    position: absolute;
    border-radius: 5px;
}
</style>

</head>
<body>
    <div class="myDiv">
        <div class="row-fluid">
            <form class="form-horizontal" id="modify_pwd_form" method="post" action="#" style="padding: 15px;">
                <div class="form-group">
                  <label class="col-sm-3 control-label" for="pwd">原始密码</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name="oldpwd" id="oldpwd" placeholder="请输入原始密码">
                    </div>
                </div>
                 <div class="form-group">
                    <label class="col-sm-3 control-label" for="pwd">新密码</label> 
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name="newpwd" id="newpwd" placeholder="请输入新密码">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label" for="pwd">确认密码</label> 
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name="confim" id="confim" placeholder="请再次输入新密码">
                    </div>
                </div>
              <div class="row">
                    <div class="col-sm-12" style="text-align: center;">
                        <input type="submit" class="btn btn-primary" value="确认修改"></input>
                    </div>
                </div> 
            </form>
            <p style="color: red;text-align: center;"></p>
        </div>
    </div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    // 当页面加载完毕执行
    $(function () {
        // 给原密码绑定一个光标移除事件
        $("#oldpwd").blur(function () {
            // 获取当前输入的密码
            const pwd = $(this).val();
            // 判断是否为空
            if (pwd.trim().length == 0) {
                alert("原密码不能为空！");
                return;
            }
            // 传统的JS方式发送异步请求
            // 1.构建XMLHttpRequest对象
            const xhr = new XMLHttpRequest();
            // 2.监听state的变化
            xhr.onreadystatechange = function () {
                // 当readyState状态为4，并且状态码为200，代表请求和响应完成
                if (xhr.readyState == 4 && xhr.status == 200) {
                    // 得到响应结果
                    const result = xhr.responseText;
                    // 判断结果
                    if (result == "true") {
                        // 密码正确
                        alert("原始密码正确");
                    } else if (result == "false") {
                        // 密码错误
                        alert("原始密码不正确");
                    } else {
                        // 出现异常
                        alert("数据库升级...");
                    }
                }
            }
            // 3.打开请求地址
            xhr.open("post", "${pageContext.request.contextPath}/loginAndLogout", true);
            // post方式需要添加头信息
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            // 4.发送请求
            xhr.send("operator=checkPwd&uname=${emp.username}&pwd=" + pwd);
        });
        // 给修改密码的表单添加事件
        $("#modify_pwd_form").submit(function () {
            // 获取新密码
            const newPwd = $("#newpwd").val();
            // 获取确认密码
            if ($("#newpwd").val() != $("#confim").val()) {
                alert("密码不一致！");
                return false;
            }
            // 前端校验完毕，直接使用异步请求进行修改密码操作
            // 使用的jQuery的方式进行异步请求
            // 1.定义需要携带的参数，使用json格式
            const data = {
                "operator": "modifyPwd",
                "uname": "${emp.username}",
                "newpwd": newPwd
            };
            $.post("${pageContext.request.contextPath}/loginAndLogout", data, function(res){
                // 成功后的结果
                if (res == "true") {
                    alert("密码修改成功");
                    // 打开新的地址：登录页面
                    window.open("${pageContext.request.contextPath}/login.jsp", "_top");
                } else if (res == "false") {
                    alert("密码修改失败！");
                } else {
                    alert("数据库升级");
                }
            });
            return false;
        });
    });
</script>
</html>