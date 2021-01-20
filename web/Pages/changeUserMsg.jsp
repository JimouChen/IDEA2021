
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改用户信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">
    <style>
        body{margin: 30px;}
    </style>
</head>
<body>

<a href="${pageContext.request.contextPath}/Pages/welcome.jsp">←返回</a>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>信息修改</legend>
</fieldset>

<form class="layui-form" action="${pageContext.request.contextPath}/changeUserMsg.car" lay-filter="example" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input name="uname"  placeholder="请输入新的用户名" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密  码</label>
        <div class="layui-input-inline">
            <input name="psw"  placeholder="请输入新的密码" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn layui-btn-normal" >确认修改</button>
        </div>

    </div>

</form>

<script src="${pageContext.request.contextPath}/src/js/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['laypage','table'], function(){
        var table = layui.table
            ,laypage = layui.laypage;
    });
</script>
</body>
</html>