<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>管理员后台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header layui-bg-green">
        <div class="layui-logo layui-bg-green">管理员后台</div>
        <%--        <i class="&#xe66f; layui-icon-username"></i>--%>


        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left layui-bg-green">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Pages/homepage.jsp">主页</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right layui-bg-green">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Pages/adminLogin.jsp">退出登录</a></li>
        </ul>

    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="${pageContext.request.contextPath}/Pages/adminBackstage.jsp">管理操作</a>

                </li>
                <li class="layui-nav-item">
                    <dd><a href="javascript:jump('${pageContext.request.contextPath}/banPublish.admin');">出售信息管理</a>
                    </dd>
                    <dd><a href="javascript:jump('${pageContext.request.contextPath}/manageVip.admin');">会员权限管理</a></dd>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <%--        <div style="padding: 15px;">内容主体区域</div>--%>
        <iframe id="iframe_a" src="${pageContext.request.contextPath}/Pages/welcome.jsp" style="width: 100%"
                height="98%"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        欢迎你
    </div>
</div>
<script src="${pageContext.request.contextPath}/src/js/layui.js"></script>
<script>
    //JavaScript代码区域
    function jump(url) {
        parent.document.getElementById("iframe_a").src = url;
    };
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
