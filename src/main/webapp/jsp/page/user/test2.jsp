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
		    	角色管理 <a class="btn btn-success navbar-right glyphicon glyphicon-refresh" href="/test2" title="刷新" ></a>
	</nav>
  
  
  	<!--搜索-->
  	<div class="container-fluid text-center">
  	  <div class="row">
		  <form action="/getRoles" method="post">
  	  	<div class="col-md-5"></div>
				<div class="col-md-2">
					<input type="text" class="form-control" style="width:220px" placeholder="角色" value="${Role}" id="Role" name="Role">
				</div>
				<div class="col-md-2">
					<button type="submit" class="btn btn-primary" id="" name=""><span class="glyphicon glyphicon-user"></span>搜角色</button>
				</div>
		  </form>
  	  </div>
  	</div>
	
	
		<!--操作-->
		<div class="operation row">
			<div class="col-md-4"> 

				<a class="btn btn-primary radius"  data-toggle="modal" data-target="#add">
					<span class="glyphicon glyphicon-plus"></span>添加角色</a> 
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
					<th width="170">角色</th>
                    <th width="170">描述</th>
					<th >权限</th>
                    <th width="170">加入时间</th>
                    <th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
            <c:forEach items="${list}" var="c" varStatus="s">
				<tr class="text-center">

					<td>${s.index+1}</td>
					<td>${c.role}</td>
					<td>${c.content}</td>
                    <td>${c.jurisdictions}</td>
                    <td>${c.createTime}</td>
					<td class="td-manage">
						<a style="text-decoration:none" data-toggle="modal" data-target="#updateTo" onclick="update(${c.rId})" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>
						<a title="编辑"   class="ml-5" data-toggle="modal" data-target="#update" onclick="Value('${c.rId}','${c.role}','${c.content}')" style="text-decoration:none"><span class="glyphicon glyphicon-pencil"></span></a>
						<a title="删除" onclick="return confirm('确定删除角色？');" href="/role/delete.action?rId=${c.rId}"  class="ml-5" style="text-decoration:none"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
            </c:forEach>
			</tbody>
		</table>
  
</div>
  </body>
  <%--模态框添加--%>
  <div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		  <div class="modal-content">
			  <form action="/role/add.action" method="post" class="register">
				  <div class="modal-header">
					  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					  <h4 class="modal-title" id="myModalLabel">添加角色：</h4>
				  </div>


				  <div class="modal-footer">
					  <div class="form-group">
						  <label  class="col-md-2">角色:</label>
						  <div class="col-md-9">
							  <input type="text" name="role" id="roles" placeholder="请输入角色名" value="" class="form-control"><br />
						  </div>
					  </div>
					  <div class="form-group">
						  <label for="content" class="col-md-2">角色信息:</label>
						  <div class="col-md-9">
							  <textarea class="form-control" name="content" id="content"  placeholder="请输入角色信息" rows="3"></textarea>
						  </div>
					  </div>
					  <br/><br/>
					  <div class="col-md-9">
						  <br/>
						  <input type="hidden" name="id" id="ID" value="1"></input>
						  <label>选择权限：</label>
						  <c:forEach items="${jurlist}" var="c" varStatus="s">
							  <input type="checkbox" name="jId" value="${c.jId}"/>${c.jurisdiction}
						  </c:forEach>
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
  <%--模态框信息修改--%>
  <div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		  <div class="modal-content">
			  <form action="/role/update.action" method="post" class="register">
				  <div class="modal-header">
					  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					  <h4 class="modal-title" id="myModalLabels">修改角色信息：</h4>
				  </div>
				  <input type="hidden" name="rId" id="rId" value="1"></input>

				  <div class="modal-footer">
					  <div class="form-group">
						  <label  class="col-md-2">角色:</label>
						  <div class="col-md-9">
							  <input type="text" name="role" id="roless" placeholder="请输入角色名" value="" class="form-control"><br />
						  </div>
					  </div>
				  <div class="form-group">
					  <label for="content" class="col-md-2">角色信息:</label>
					  <div class="col-md-9">
						  <textarea class="form-control" name="content" id="contents"  placeholder="请输入角色信息" rows="3"></textarea>
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
  <%--模态框角色权限分配--%>
  <div class="modal fade" id="updateTo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		  <div class="modal-content">
			  <form action="/role/updateTojur.action" method="post" class="register">
				  <div class="modal-header">
					  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					  <h4 class="modal-title" id="myModalLabelss">权限分配：</h4>
				  </div>


				  <div class="modal-footer">
					  <div class="col-md-10">
						  <input type="hidden" name="rId" id="rIds" value="1"></input>
						  <br/><br/>
						  <label>选择权限：</label>
						  <c:forEach items="${jurlist}" var="c" varStatus="s">
							  <input type="checkbox" name="jId" value="${c.jId}"/>${c.jurisdiction}
						  </c:forEach>
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

  <script >
  $("#update").modal("hide");
  function Value(rID,role,content) {
  $("#rId").val(rID);
  $("#roless").val(role);
  $("#contents").val(content);
  }
  $("#updateTo").modal("hide");
  function update(rID) {
      // alert(00);
      $("#rIds").val(rID);

  }
  </script>
</html>
