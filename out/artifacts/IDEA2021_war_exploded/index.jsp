<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--  <head>--%>
<%--    <title>HomePage</title>--%>
<%--  </head>--%>
<%--  <body>--%>
<%--  Hello--%>
<%--  </body>--%>
<%--</html>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>登录</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body style="background: url(src/images/banner1.jpg);background-attachment: fixed;">


<div class="layui-layout layui-layout-admin">
  <div class="layui-header layui-bg-blue">
    <div class="layui-logo layui-bg-blue">新东莞培训机构教学系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left layui-bg-blue">
      <li class="layui-nav-item"><a href="homepage.Homepage">首页</a></li>
      <li class="layui-nav-item"><a href="classpage.Homepage">课程</a></li>
      <li class="layui-nav-item"><a href="newspage.Homepage">新闻</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right layui-bg-blue">
      <li class="layui-nav-item">
      <li class="layui-nav-item layui-this"><a href="Login.jsp">登录</a></li>
      <li class="layui-nav-item"><a href="Register.jsp">学员注册</a></li>
      </li>
    </ul>
      <!--<li class="layui-nav-item "><a href="">个人中心</a></li>
      <a href="javascript:;">
        <img src="https://s3.ax1x.com/2020/11/23/DYiWq0.jpg" class="layui-nav-img">
        xiaooo
      </a>
      <dl class="layui-nav-child">
        <dd><a href="javascript:;">修改信息</a></dd>
          <dd><a href="javascript:;">安全管理</a></dd>
        <dd><a href="javascript:;">退出登录</a></dd>
      </dl>-->


  </div>
</div>




<div class="layui-container">
  <div class="layui-row">
    　<br><br><br><br><br><br>
  </div>
  <div class="layui-row layui-col-space20">
    <div class="layui-col-md6">
      <div class="layui-card">
        <div class="layui-card-header"><h3>登录</h3></div>
        <div class="layui-card-body">
          <form class="layui-form" id="info" action="Login.Enter" lay-filter="example" method="post">
            <div class="layui-form-item">
              <label class="layui-form-label">身份</label>
              <div class="layui-input-block">
                <input type="radio"  name="identity" value="0" title="学员" checked="">
                <input type="radio"  name="identity" value="1" title="培训师">
                <input type="radio"  name="identity" value="2" title="管理员">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">账　号</label>
              <div class="layui-input-inline">
                <input type="text" name="no" placeholder="请输入账号" class="layui-input" id="no">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">密　码</label>
              <div class="layui-input-inline">
                <input type="password" name="password" placeholder="请输入密码" id="password" autocomplete="off" class="layui-input">
              </div>
            </div>

            <div class="layui-form-item">
              <div class="layui-input-block">
                <input type="submit"  id="entry_btn" value="登录" class="layui-btn layui-btn-normal">
                <a href="Register.jsp" class="layui-btn layui-btn-normal">学员注册</a>

              </div>

            </div>
            <h2 align='center' >${requestScope.MESSAGE }</h2>
          </form>
        </div>
      </div>
    </div>
    <div class="layui-col-md6">
      <div class="layui-card">
        <div class="layui-card-header"><h3>关于我们</h3></div>
        <div class="layui-card-body">
          新东莞*****是新东方教育科技集团旗下的IT教育品牌<br>
          为8至88岁程序员提供一流的教学培训服务。<br>
          根据不同成长阶段的特点，依托科技产品和学习工具<br>
          提供全科培训课程。<br><br>
          <img src="Information/ourselves.jpg" width="80%" height="80%">
        </div>
      </div>
    </div>
  </div>
</div>









<script src="static/layui/layui.js"></script>
<script>
  function jump(url) {
    parent.document.getElementById("iframe_a").src = url;
  };

  layui.use(['form','element','layer'], function(){
    var form = layui.form
            ,layer = layui.layer
            ,element = layui.element;
  });


  /**
   function jump(){
	var obj=document.getElementsByName("identity");
	for (var i=0;i<obj.length;i++){ //遍历Radio
		if(obj[i].checked){
			break;
		}
	}

	if(i==2){
		window.open ("BackstageAdmin.jsp")
	}
	if(i==0){
		window.open ("BackstageStudent.jsp")
	}
	if(i==1){
		window.open ("BackstageTescher.jsp")
	}

}
   **/

</script>
<center><a href="Pages/login.jsp"><h1>进入登录页</h1></a> </center>
</body>
</html>
