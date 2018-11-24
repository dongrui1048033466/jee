<!--/*!
 * @名称：用户管理
 * @作者：董瑞
 * @日期：2018-06-27
 */-->

<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta charset="UTF-8" />
	<title>不动产</title>
	<!--<link rel="stylesheet" href="css/base.css" />
	<link rel="stylesheet" href="css/layout.css"/>-->
	<meta name="author" >

	<link href="${pageContext.request.contextPath}/Bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/Bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel=s "stylesheet"/>
	<script src="${pageContext.request.contextPath}/Bootstrap/jquery-2.1.4/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/Bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>

	<link href="${pageContext.request.contextPath}/jqui/jquery-ui.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.2.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jqui/jquery-ui.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/zhuce.js"></script>
    <title>首页</title>
    
    <style type="text/css">
    	body{
    		margin: 0px;
    		padding: 0px;
    	}
    	.full{
    	width: 99%;
	    margin-right: 5px;
    	}
    .breadcrumb{
	    background-color: #f5f5f5;
	    padding: 5px 10px;
	    z-index: 99;
	    height: 40px;
	    width: 100%;
	  
    }
    .operation{
    	padding:8px;
    	background: #F5FAFE;
    	margin-top: 5px;
    	margin-right: 2px;
    	
    }
    .breadcrumb .btn{
    	width: 30px;
    	height: 30px;
    	margin-right:0px;
    	padding: 3px;    	
    }
    table thead{
    	background: #F5FAFE;
    
    }
    </style>
  </head>
  
  <body>
<div class="full">
	<!--导航-->
	<nav class="breadcrumb"><span class="glyphicon glyphicon-home"></span>
		    	首页 <span class="c-gray en">&gt;</span> 
		    	机构用户 <span class="c-gray en">&gt;</span> 
		    	用户管理 <a class="btn btn-success navbar-right glyphicon glyphicon-refresh" href="/test1" title="刷新" ></a>
	</nav>
  
  
  	<!--搜索-->
  	<div class="container-fluid text-center">
  	  <div class="row">
		  <div class="col-md-3"><font color="red"> ${msg}
		  </font></div>
		  <form action="/getUserRoles" method="post">
			  <div class="col-md-2">
				  <input type="text" class="form-control" style="width:180px" placeholder="输入登录名" VALUE="${loginName}" name="loginName">
			  </div>
			  <div class="col-md-2">
				  <input type="text" class="form-control" style="width:180px" placeholder="输入名字" value="${userName}" name="userName">
			  </div>
			  <div class="col-md-1">
				  <button type="submit" class="btn btn-primary"  ><span class="glyphicon glyphicon-user"></span>搜用户</button>
			  </div>
		  </form>
  	  </div>
  	</div>
	
	
		<!--操作-->
		<div class="operation row">
			<div class="col-md-4">
				<a href="javascript:;" data-toggle="modal" data-target="#add" class="btn btn-primary radius">
					<span class="glyphicon glyphicon-plus"></span>添加用户</a> 
				<a href="${pageContext.request.contextPath}/jsp/download_excel" onclick=" " class="btn btn-primary radius">
					<span class="glyphicon glyphicon-plus"></span>导出表</a> 
			</div>
			<div class="text-right">共有数据：<strong>${count}</strong>条</div>
		</div>
		<!--列表信息-->
	<table class="table table-border table-bordered table-bg">
		<thead>
		<tr>
			<th scope="col" colspan="12">员工列表</th>
		</tr>
		<tr class="text-center">
			<th width="40">ID</th>
			<th width="90">登录名</th>
			<th width="90">姓名</th>
			<th width="90">手机</th>
			<th width="150">邮箱</th>
			<th width="150">身份证号码</th>
			<th>角色</th>
			<th width="130">加入时间</th>
			<th width="100">操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="c" varStatus="s">
			<tr class="text-center">
				<td>${s.index+1}</td>
				<td>${c.loginName}</td>
				<td>${c.userName}</td>
				<td>${c.phone}</td>
				<td>${c.email}</td>
				<td>${c.idCard}</td>
				<td>${c.roles}</td>
				<td>${c.createTime}</td>
				<td>
				    <a style="text-decoration:none" data-toggle="modal" data-target="#updateToRole" title="角色分配" onclick="update(${c.id})"><i class="Hui-iconfont">&#xe631;</i></a>
					<a title="编辑" data-toggle="modal" data-target="#update" onclick="Value('${c.id}','${c.loginName}','${c.userName}','${c.phone}','${c.email}','${c.idCard}','${c.loginPwd}','${c.isDelete}')" ><span class="glyphicon glyphicon-pencil"></span></a>
					<a title="删除" onclick="return confirm('确定删除用户？');" href="/user/delete.action?id=${c.id}&loginName=${loginName}&userName=${userName}" class="ml-5" style="text-decoration:none"><span class="glyphicon glyphicon-trash"></span></a></td>
				</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>

</div>

<%--模态框添加--%>
<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="/user/add.action" method="post" class="register">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">添加用户：</h4>
			</div>


				<div class="modal-footer">
					<div class="form-group">
						<label  class="col-md-2">账号:</label>
						<div class="col-md-9">
							<input type="text" name="loginName" id="loginName" placeholder="请输入账号" class="form-control"><br />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-md-2">姓名:</label>
						<div class="col-md-9">
							<input type="text" name="userName" id="name" placeholder="请输入用户名" class="form-control"><br />
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-2">邮箱:</label>
						<div class="col-md-9">
							<input type="text" name="email" id="email" value="" placeholder="请输入邮箱" class="form-control"><br />
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-md-2">手机:</label>
						<div class="col-md-9">
							<input type="text" name="phone" id="phone" required lay-verify="required"
								   placeholder="请输入手机号码" autocomplete="off" class="form-control"><br/>
						</div>
					</div>
					<div class="form-group">
						<%--@declare id="idcard"--%><label for="idCard" class="col-md-2">身份证号:</label>
						<div class="col-md-9">
							<input type="text" name="idCard" id="idCard" required lay-verify="required"
								   placeholder="请输入身份证号码" autocomplete="off" class="form-control"><br/>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-2">密码:</label>
						<div class="col-md-9">
							<input type="password" name="loginPwd" id="password0" value="" placeholder="请输入密码" class="form-control"><br />
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-2">确认密码:</label>
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
					</div>


					<div class="col-md-7">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary" >提交更改</button>
					</div>
				</div>
			</form>
		</div>

		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>

<%--模态框修改基本信息--%>
<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="/user/update.action" method="post" class="register">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabels">修改用户：</h4>
				</div>


				<div class="modal-footer">
					<input type="hidden" name="id" id="ids" value="1"></input>
					<input type="hidden" name="isDelete" id="isDelete" value="1"></input>
					<div class="form-group">
						<label  class="col-md-2">账号:</label>
						<div class="col-md-9">
							<input type="text" name="loginName" id="loginNames" value="1" placeholder="请输入账号" class="form-control"><br />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-md-2">姓名:</label>
						<div class="col-md-9">
							<input type="text" name="userName" id="names" value="1" placeholder="请输入用户名" class="form-control"><br />
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-2">邮箱:</label>
						<div class="col-md-9">
								<input type="email" name="email" id="emails" value="1" placeholder="请输入邮箱" class="form-control"><br />
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-md-2">手机:</label>
						<div class="col-md-9">
							<input type="text" name="phone" id="phones" value="1" required lay-verify="required"
								   placeholder="请输入手机号码" autocomplete="off" class="form-control"><br/>
						</div>
					</div>
					<div class="form-group">
						<%--@declare id="idcard"--%><label for="idCard" value="1" class="col-md-2">身份证号:</label>
						<div class="col-md-9">
							<input type="text" name="idCard" value="1" id="idCards" required lay-verify="required"
								   placeholder="请输入身份证号码" autocomplete="off" class="form-control"><br/>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-2">密码:</label>
						<div class="col-md-9">
							<input type="password" name="loginPwd" id="passwords" value="" placeholder="请输入密码" class="form-control"><br />
						</div>
					</div>


					<div class="col-md-7">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" >提交更改</button>
					</div>
				</div>
			</form>
		</div>

		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>

<%--模态框修改角色--%>
<div class="modal fade" id="updateToRole" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabelss">角色分配：</h4>
			</div>
			<form action="/updateToRole.action" method="post">
				<div class="modal-body">
			<input type="hidden" name="id" id="ID" value="1"></input>
					<label>角色分配：</label>
			<c:forEach items="${roleList}" var="c" varStatus="s">
					<input type="checkbox" name="rId" value="${c.rId}"/>${c.role}
			</c:forEach>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary" >提交更改</button>
				</div>
			</form>
		</div>

		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>
  </body>

<script >
    $("#update").modal("hide");
    function Value(ID,loginName,userName,phone,email,idCard,loginpwd,isDelete) {
        $("#ids").val(ID);
        $("#loginNames").val(loginName);
        $("#names").val(userName);
        $("#phones").val(phone);
        $("#emails").val(email);
        $("#idCards").val(idCard);
        $("#passwords").val(loginpwd);
        $("#isDelete").val(isDelete);

    }
    $("#updateToRole").modal("hide");
    function update(ID) {
        $("#ID").val(ID);

    }
</script>
</html>
