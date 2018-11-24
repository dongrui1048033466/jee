<!--/*!
 * @名称：机构管理
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
<html>
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta name="keywords">
	<meta name="description">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
  <link href="../../Bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
		<link href="../../Bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel=s "stylesheet"/>
		<script src="../../Bootstrap/jquery-2.1.4/jquery.min.js" type="text/javascript"></script>
		<script src="../../Bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		
		<link href="../../jqui/jquery-ui.css" rel="stylesheet" />
		<script type="../../text/javascript" src="js/jquery-2.0.2.js" ></script>
		<script type="../../text/javascript" src="jqui/jquery-ui.js" ></script>
		<script type="../../text/javascript" src="js/jquery.validate.js" ></script>
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
	    padding: 5 10px;
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
		    	机构管理 <a class="btn btn-success navbar-right glyphicon glyphicon-refresh" href="javascript:location.replace(location.href);" title="刷新" ></a>
	</nav>
  
  
  	<!--搜索-->
  	<div class="container-fluid text-center">
  	  <div class="row">
  	  	<div class="col-md-5"></div>
				<div class="col-md-2">
					<input type="text" class="form-control" style="width:220px" placeholder="机构名称" id="" name="">
				</div>
				<div class="col-md-1">
					<button type="submit" class="btn btn-primary" id="" name=""><span class="glyphicon glyphicon-user"></span>搜机构</button>
				</div>
  	  </div>
  	</div>
	
	
		<!--操作-->
		<div class="operation row">
			<div class="col-md-4">
				<a href="javascript:;" onclick="admin_add('添加角色','admin-add.html','800','500')" class="btn btn-primary radius">
					<span class="glyphicon glyphicon-plus"></span>添加机构</a> 
			</div>
			<div class="text-right">共有数据：<strong>${count}</strong>条</div>
		</div>
		<!--列表信息-->
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="9">员工列表</th>
				</tr>
				<tr class="text-center">
					<th width="40">ID</th>
					<th width="150">机构名</th>
					<th >机构信息</th>
					<th width="90">下级机构</th>
					<th width="90">创建时间</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="c" varStatus="s">
				<tr class="text-center">
					<td>${s.index+1}</td>
					<td>${c.mechanism}</td>
					<td>${c.content}</td>
					<td>  </td>
					<td>${c.createTime}</td>
					<td class="td-manage">
						<a style="text-decoration:none" onClick="admin_stop(this,'10001')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a> 
						<a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','admin-add.html','1','800','500')" class="ml-5" style="text-decoration:none"><span class="glyphicon glyphicon-pencil"></span></a> 
						<a title="删除" href="javascript:;" onclick="admin_del(this,'1')" class="ml-5" style="text-decoration:none"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
  
</div>
  </body>
  

</html>
