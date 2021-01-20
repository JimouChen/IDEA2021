<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户后台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">用户后台</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Pages/homepage.jsp">主页</a></li>
            <%--            <li class="layui-nav-item"><a href="">会员权限管理</a></li>--%>
            <%--            <li class="layui-nav-item"><a href="">出售信息管理</a></li>--%>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:jump('${pageContext.request.contextPath}/Pages/changeUserMsg.jsp');">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    用户信息修改
                </a>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="">基本资料</a></dd>--%>
<%--                    <dd><a href="">安全设置</a></dd>--%>
<%--                </dl>--%>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Pages/login.jsp">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">

                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="${pageContext.request.contextPath}/Pages/userBackstage.jsp">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:jump('${pageContext.request.contextPath}/update.do');">查看编辑二手车信息</a></dd>
                        <dd><a href="javascript:jump('${pageContext.request.contextPath}/publishedMsg.do');">查看已发布信息</a></dd>
                        <dd><a href="javascript:jump('${pageContext.request.contextPath}/queryComment.car');">查看他人留言信息</a></dd>
                        <dd><a href="javascript:jump('${pageContext.request.contextPath}/querySelfComment.car');">查看我的回复信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:jump('${pageContext.request.contextPath}/lookOthersCar.car');">查看他人二手车信息</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <%--        <div style="padding: 15px;">内容主体区域</div>--%>
        <iframe id="iframe_a" src="${pageContext.request.contextPath}/Pages/welcome.jsp" style="width: 100%" height="98%"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 2021 MIT license
    </div>
</div>

<%=session.getAttribute("userid")%>

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


