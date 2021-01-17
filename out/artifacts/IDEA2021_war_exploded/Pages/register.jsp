<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css" media="all">
</head>
<body style="background: url(${pageContext.request.contextPath}/src/images/banner2.jpg);background-attachment: fixed;">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 200px;">
    <center><h1>注 册 页</h1></center>
</fieldset>

<form class="layui-form" action="${pageContext.request.contextPath}/register.do" method="post">

    <div align="center">

        <label>账　号</label>
        <div class="layui-input-inline">
            <input type="text" name="uid" placeholder="请输入账号" class="layui-input">
        </div>
        <br><br>

        <label>用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="username" placeholder="请输入用户名" class="layui-input">
        </div>
        <br><br>

        <label>密　码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" placeholder="请输入密码" id="password" autocomplete="off"
                   class="layui-input">
        </div>
        <br><br>

        <div align="center">
            <input type="submit" id="entry_btn1" value="会员注册" class="layui-btn layui-btn-normal">
            <a href="${pageContext.request.contextPath}/Pages/login.jsp" class="layui-btn layui-btn-normal">返回登录</a>
        </div>

        <br>
        <br>
        <br>
        <h2 align='center'>${requestScope.registerMassage }</h2>


    </div>
</form>
</body>
</html>
