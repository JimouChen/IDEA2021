<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>查看已发布信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>信息管理</legend>
</fieldset>


<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>🚗汽车信息</th>
            <th>💰价格</th>
            <th>👮‍车主</th>
            <th>✔发布状态</th>
            <th>💬留言功能</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty requestScope.selfCarMsg}">
            <c:forEach items="${requestScope.selfCarMsg}" var="s" >
                <tr>
                    <td>${s.msg}</td>
                    <td>${s.price}元</td>
                    <td>${s.carOwner}</td>
                    <td>${s.publish} 🚫(无法修改)🈲</td>
                    </td>
                    <th>
                        <a href="javascript:sent()" class="layui-btn layui-btn-primary layui-btn-xs">进入留言📝</a>
                        <a href="javascript:sent()" class="layui-btn layui-btn-normal layui-btn-xs">留言关闭</a>
                    </th>
                </tr>
            </c:forEach>
        </c:if>


        </tbody>
    </table>
</div>

</body>
</html>