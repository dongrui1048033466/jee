<!--/*!
 * @名称：模板构建
 * @作者：董瑞
 * @日期：2018-06-27
 */-->
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<!DOCTYPE HTML>
<html>
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta name="keywords">
	<meta name="description">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
  <link href="${pageContext.request.contextPath}/Bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/Bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel=s "stylesheet"/>
		<script src="${pageContext.request.contextPath}/Bootstrap/jquery-2.1.4/jquery.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/Bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		
		<link href="${pageContext.request.contextPath}/jqui/jquery-ui.css" rel="stylesheet" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.2.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jqui/jquery-ui.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js" ></script>
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
		.content-tab{
			cursor:pointer;
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
		             机构用户<span class="c-gray en">&gt;</span> 
		             注册审核<a class="btn btn-success navbar-right glyphicon glyphicon-refresh" href="/user/test5" title="刷新" ></a>
	</nav>
  
  
  	<!--搜索-->
  	<div class="container-fluid text-center">
  	  <div class="row">
  	  	<div class="col-md-3"><font color="red"> ${msg}
		</font></div>
	    <form action="/getUsers" method="post">
  	  	<div class="col-md-2">
  	  		<input type="text" class="form-control" style="width:180px" placeholder="输入登录名" VALUE="${loginName}"  name="loginName">
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
		<!--操作-->
		<div class="operation row">
			<div class="col-md-4"> 
				<%--<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">--%>
				  <%--<span class="glyphicon glyphicon-trash"></span> 批量删除</a> --%>
				<%--<a href="javascript:;" onclick="admin_add('添加角色','admin-add.html','800','500')" class="btn btn-primary radius">--%>
					<%--<span class="glyphicon glyphicon-plus"></span>添加区域</a> --%>
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
					<th width="100">审核结果</th>
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
					<%--<td class="td-status"><span class="label label-success radius">${c.isDelete==0?'未审核':c.isDelete==1?'审核不通过':'审核通过'}</span></td>--%>
					<td class="td-status">
							${c.isDelete==0?'<span class="label label-info radius">未审核</span>':c.isDelete==1?'<span class="label label-danger radius">审核不通过</span>':'<span class="label label-success radius">审核通过</span>'}
					<td class="td-manage">
						<a style="text-decoration:none" data-toggle="modal" data-target="#update" title="审核" onclick="Values(${c.id})"><i class="Hui-iconfont">&#xe631;</i></a>
						<%--<a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','admin-add.html','1','800','500')" class="ml-5" style="text-decoration:none"><span class="glyphicon glyphicon-pencil"></span></a> --%>
						<%--<a title="删除" href="javascript:;" onclick="admin_del(this,'1')" class="ml-5" style="text-decoration:none"><span class="glyphicon glyphicon-trash"></span></a></td>--%>
                    </td>
                </tr>
            </c:forEach>

			</tbody>
		</table>
  
</div>



<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">审核：</h4>
            </div>
    <form action="/user/shenhe.action" method="post">
            <div class="modal-body">
                <input type="hidden" name="id" id="id" value="1"></input>
				<input type="hidden" name="loginName"  value="${loginName}"></input>
				<input type="hidden" name="userName"  value="${userName}"></input>
                <label>审核：</label>
                <input type="radio" name="isDelete" value="0" title="未审核" >未审核</input>
                <input type="radio" name="isDelete" title="审核不通过"  value="1">审核不通过</input>
                <input type="radio" name="isDelete" title="审核通过"  value="2">审核通过</input>
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
      function Values(ID) {
          // alert("00");
          $("#id").val(ID);
      }
  </script>
</html>
