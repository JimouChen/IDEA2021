<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>管理权限</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>发布权限管理</legend>
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
            <th>👮发布者</th>
            <th>🚗汽车信息</th>
            <th>💰价格</th>
            <th>🖐信息管理</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty requestScope.AdminPbMsg}">
            <c:forEach items="${requestScope.AdminPbMsg}" var="s" >
                <tr>
                    <td>${s.username}</td>
                    <td>${s.msg}</td>
                    <td>${s.price}元</td>
                    <th>
                        <a href="${pageContext.request.contextPath}/banUserPb.admin?car_id=${s.carId}" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger">屏蔽信息</a>
                    </th>
                </tr>
            </c:forEach>
        </c:if>


        </tbody>
    </table>
</div>

</body>
</html>