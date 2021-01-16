<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css" media="all">
</head>
<body style="background: url(${pageContext.request.contextPath}/src/images/banner1.jpg) fixed;">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 200px;">
    <center><h1>会员登录页</h1></center>
</fieldset>

<form class="layui-form" action="${pageContext.request.contextPath}/userLogin.enter" method="post">

    <div align="center">

        <label>账　号</label>
        <div class="layui-input-inline">
            <input type="text" name="uid" placeholder="请输入账号(数字)" class="layui-input" id="no">
        </div>
        <br><br>


        <label>密　码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" placeholder="请输入密码" id="password" autocomplete="off"
                   class="layui-input">
        </div>
        <br><br>

        <div align="center">
            <input type="submit" id="entry_btn1" value="会员登录" class="layui-btn layui-btn-normal">
<%--            <input type="submit" id="entry_btn2" value="管理员登录" class="layui-btn layui-btn-normal">--%>
            <a href="register.jsp" class="layui-btn layui-btn-normal">会员注册</a>
        </div>

    </div>
    <br>
    <br>
    <br>
    <h2 align='center'>${requestScope.Massage }</h2>
</form>
</body>
</html>
