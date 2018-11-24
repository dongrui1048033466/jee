<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<meta charset="utf-8" />
		<title>不动产系统登录</title>
		<link href="Bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
		<link href="Bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel=s "stylesheet"/>
		<script src="Bootstrap/jquery-2.1.4/jquery.min.js" type="text/javascript"></script>
		<script src="Bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		
		<link href="jqui/jquery-ui.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/loginstyle.css" />
		<script type="text/javascript" src="js/jquery-2.0.2.js" ></script>
		
		
		
		
		<style type="text/css">
			body 
			{
				border: 0px;
				padding: 0px;
				background: url(img/admin-login-bg.jpg);
				background-repeat: no-repeat;
				background-size: cover;
			}
			.navbar{
				background: rgba(45,45,48,0.5);
				border: none;
				height: 25px;
			
			}
			.fu{
				width: 90%;
				color:white !important;
				font-size: 16px;
			}
			.fu p,a{
				color:white !important;
					}
			.fu a:hover{
				color:#000000 !important;
					}
			.active{
				color: cornflowerblue !important;
			}
			.denglu{
				margin-left: 50px;
			}
			
			.form 
			{
				background: rgba(255,255,255,0.2);
				margin:  auto;
				margin-top: 90px;
				width: 600px;
			}
		footer{
		background: rgba(45,45,48,0.5);
		color:#bdbdbd;
		margin-top: 50px;
		padding-bottom: 10px;

		}
		</style>
		 <!--<%
    	//获取Cookie实例对象中的元素值
    	Cookie[] cookie=request.getCookies();
    	String username="";
    	String password="";
    	if(cookie!=null && cookie.length>0){
    		for(Cookie c:cookie){
    			if(c.getName().equals("username")){
    				username=c.getValue();
    			}
    			if(c.getName().equals("password")){
    				password=c.getValue();
    			}
    		}
    	}
    %>-->

	</head>

	<body>
	<!--header-->
	<nav class="navbar navbar-default">
      <div class="fu container-fluid">
        <div class="navbar-header">
          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-responsive-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <p class="navbar-brand">不动产系统</p> 
        </div>
        <div class="collapse navbar-collapse navbar-responsive-collapse navbar-right">
          <ul class="nav navbar-nav">
            <li><a href="#" class="active">登录页面</a></li>
            <li><a href="#">管理中心</a></li>
          </ul>
        </div>
      </div>
    </nav>
	<!-- // header end -->
	
	
	<div class="form" >
		<form action="userLogin.action" method="post" style="align-content: center;">
			
			<div style="margin-left: 100px;padding-top: 40px; ">
				
				<div class="denglu">		
				<h3>欢迎访问不动产系统</h3>
				</div>
				
				<input type="text" class="form-control" placeholder="账号" name="loginName" style="width: 350px; height: 40px; " value="${user.loginName}" />
				<br>
				
				<input type="password" class="form-control" placeholder="密码" name="loginPwd" style="width: 350px; height: 40px; " />
				<br>
				<div class="row">
					<div class="col-md-4">
					<input type="text" class="form-control" placeholder="验证码"  name="usercode" style="width:150px;height: 40px;"/>
					</div>
					<div class="col-md-2">
						点击刷新
					</div>

					<div class="col-md-2">
					<!-- 为了避免IE的缓存bug  需要每次请求带上不一样的参数 这个参数可以没有任何意义  关键是要不一样 -->
				   <img src="CheckCode"   onclick="this.src='CheckCode?rand='+Math.random()"/><!-- /在html和转发Dispatcher里面的含义不同  前者表示服务器根目录  8080:/   后者表示当前应用根目录 8080/ph/ -->
					</div>
				</div>

                <br>
				<p>没有账户？
					<a href="zhuce" class="opener" id="opener"><span class="glyphicon glyphicon-user"></span>注册</a>
				</p>
				<input type="submit" name="submit" class="btn btn-primary " value="登录" style="width: 350px; font-weight: 600; font-size: 16px;">
				<br>
				<br>

				<%--<td colspan="2"><input type="checkbox" name="isUseCookie" checked="checked"/>十天内记住我的登录状态</td>--%>
			<font color="red"> ${msg} 
						</font>
				
			</div>
			<br>
		</form>
	</div>
	
		
     
 
   
<footer class="container-fluid text-center">
  <h2>
   <a href="#MyPage" title="To Top">
     <span class="glyphicon glyphicon-chevron-up tu2" style="color:#FFFFFF"></span>
   </a>
  </h2>
      <p>Copyright 不动产系统  by DR</p>
  </footer>          

	</body>
</html>