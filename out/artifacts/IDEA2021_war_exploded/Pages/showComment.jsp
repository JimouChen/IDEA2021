<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>查看留言</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>留言信息</legend>
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
            <th>💬评论</th>
            <th>👮‍留言人</th>
            <th>📝留言回复</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty requestScope.Comment}">
            <c:forEach items="${requestScope.Comment}" var="s" >
                <tr>
                    <td>${s.carMsg}</td>
                    <td>${s.comm}</td>
                    <td>${s.comManName}</td>
                    <th>
                        <a href="${pageContext.request.contextPath}/ansComment.car?car_id=${s.carId}" class="layui-btn layui-btn-normal layui-btn-xs">回复</a>
                    </th>
                    </td>
                </tr>
            </c:forEach>
        </c:if>


        </tbody>
    </table>
</div>

</body>
</html>