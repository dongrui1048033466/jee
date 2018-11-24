<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>不动产</title>
	<!--<link rel="stylesheet" href="css/base.css" />
	<link rel="stylesheet" href="css/layout.css"/>-->
	<meta name="author" >
	
	    <link href="${pageContext.request.contextPath}/Bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/Bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet"/>
		<script src="${pageContext.request.contextPath}/Bootstrap/jquery-2.1.4/jquery.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/Bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		
		<link href="${pageContext.request.contextPath}/jqui/jquery-ui.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.2.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jqui/jquery-ui.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/zhuce.js"></script>
	<style type="text/css">
		body{
			padding: 0px;
			margin: 0px;
			background: #E9EAEB;
		}
			.navbar{
				background: rgba(45,45,48,0.9);
				border: none;
				height: 25px;
			
			}
			.fu{
				width: 90%;
				color:white !important;
				font-size: 22px;
			}
			.fu p,a{
				color:white !important;
					}
			.fu a:hover{
				color:#64BD2E !important;
					}
			.active{
				color: #64BD2E !important;
			}
			.container{
				width: 85%;
				border: inset 2px;
				font-size: 17px;
				background: #FFFFFF;
			}
			.box{
				padding: 20px 0px ;
				background:rgba(45,45,48,0.9);
				font-size: 20px;
				color: white;
			}
			form{
				margin: 35px 0px ;
				
			}
			.register{
				margin-left:30%;
				
				margin-right:30%;
			}
				footer{
			background: rgba(45,45,48,0.9);
			color:#bdbdbd;
			margin-top: 50px;
			padding-bottom: 10px;
	
			}
	</style>
</head>
<body>
	
	<!--header-->
	<nav class="navbar navbar-default">
      <div class="fu container-fluid">
        <div class="navbar-header">
          <p class="navbar-brand">不动产系统</p> 
        </div>
        <div class="collapse navbar-collapse navbar-responsive-collapse navbar-right">
          <ul class="nav navbar-nav">
            <li><a href="/login" >登录页面</a></li>
            <li><a href="#" class="active">管理中心</a></li>
          </ul>
        </div>
      </div>
   </nav><!-- // header end -->
   
   
	    <div class="container">
		    <div class="box row">
		    	<div class="col-md-2"></div>
		    	<div class="col-md-3">
		    		<a href="#" class="active">1.进行注册</a> 
		    	</div>
		    	<div class="col-md-3">
		    		2.审核中
		    	</div>
		    	<div class="col-md-3">
		    		3.审核成功
		    	</div>
		    </div>

			<%--注册表单--%>
				<form action="/adds.action"  method="post" class="register">
				  <fieldset>
				  
				   <div class="form-group">
					    <%--@declare id="name"--%><label for="name" class="col-md-3">账号:</label>
					    <div class="col-md-9">
					    	<input type="text" name="loginName" id="loginName" placeholder="请输入账号" class="form-control"><br />
					    </div>
				   </div>
				   <div class="form-group">
					    <label for="name" class="col-md-3">姓名:</label>
					    <div class="col-md-9">
					    	<input type="text" name="userName" id="name" placeholder="请输入用户名" class="form-control"><br />
					    </div>
				    </div>
				    <div class="form-group">
				    <label for="email" class="col-md-3">邮箱:</label>
				    <div class="col-md-9">
				    <input type="text" name="email" id="email" value="" placeholder="请输入邮箱" class="form-control"><br />
				    </div>
				    </div>
				    <div class="form-group">
				    <label for="phone" class="col-md-3">手机:</label>
				    <div class="col-md-9">
				    <input type="text" name="phone" id="phone" required lay-verify="required"
								placeholder="请输入手机号码" autocomplete="off" class="form-control"><br/>
				    </div>
				    </div>
				    <div class="form-group">
						  <%--@declare id="idcard"--%><label for="idCard" class="col-md-3">身份证号:</label>
						  <div class="col-md-9">
							  <input type="text" name="idCard" id="idCard" required lay-verify="required"
									 placeholder="请输入身份证号码" autocomplete="off" class="form-control"><br/>
						  </div>
				     </div>
				    <div class="form-group">
				        <label for="password" class="col-md-3">密码:</label>
						<div class="col-md-9">
						<input type="password" name="loginPwd" id="password0" value="" placeholder="请输入密码" class="form-control"><br />
						</div>
				    </div>
				    <div class="form-group">
						<label for="password" class="col-md-3">确认密码:</label>
						<div class="col-md-9">
						<input type="password" name="password" id="password" value="" placeholder="请再次输入密码" class="form-control"><br />
						</div>
				    </div>
				    <div class="col-md-7">
					<%--@declare id="birth"--%><label for="birth">用户类型:</label>
					 	<select name="rId">
							<c:forEach items="${roleList}" var="c" varStatus="s">
								   <option value="${c.rId}">${c.role}</option>
							</c:forEach>
						</select>
						<br/><br/>
					<label>性别：</label>
						    <input type="radio" name="sex" value="1" title="男" checked>男</input>
							<input type="radio" name="sex" title="女"  value="0">女</input>
						<br/><br/>
				   
				  	<button type="submit" class="col-md-7 btn btn-primary" id="" name="">
				  		提交
				  	</button>
				    </div>
				  </fieldset>
				  </form>
		</div><!-- // container end -->
		
			
		<!--footer-->
	<footer class="container-fluid text-center">
		  <h2>
		   <a href="#MyPage" title="To Top">
		     <span class="glyphicon glyphicon-chevron-up tu2" style="color:#FFFFFF"></span>
		   </a>
		  </h2>
          <p>Copyright 不动产系统  by DR</p>
    </footer>    <!--footer end -->      
	
	</body>
</html>
