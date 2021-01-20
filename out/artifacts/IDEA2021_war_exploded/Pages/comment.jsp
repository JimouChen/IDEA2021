<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>留言列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">
    <style>
        /*mes-send*/
        .mes-send {
            padding: .65em;
            border: 1px solid #ccc;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
        }

        .form-group {
            padding: 1.25em;
        }

        .form-group label {
            vertical-align: top;
        }

        .mes-send input[type="text"],
        .mes-send textarea {
            padding: 1px;
            width: 40%;
            border: 1px solid #b7b7b7;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
        }

        .mes-send input {
            height: 2em;
        }

        #btn {
            margin-left: 1.25em;
            padding: 5px;
            border: none;
            -webkit-border-radius: 1.25em;
            -moz-border-radius: 1.25em;
            border-radius: 1.25em;
            width: 15%;
            font-size: 12pt;
            color: #fff;
            background-color: #66f;
            cursor: pointer;
        }

        #btn:hover {
            background-color: #03c;
        }
    </style>

</head>
<body>

<a href="${pageContext.request.contextPath}/lookOthersCar.car">←返回</a>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>留言评论</legend>
</fieldset>

<section class="mes-send">

    <form action="${pageContext.request.contextPath}/saveComment.car" method="post" class="STYLE-NAME">

        <div class="form-group">
            <label for="user_mes">留言：</label>
            <textarea id="user_mes" name="comm" style="width:800px; height:200px;"></textarea>
        </div>
        <input type="submit" value="提 交">
    </form>
</section>
</body>
</html>