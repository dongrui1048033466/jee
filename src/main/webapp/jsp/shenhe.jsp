<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8" />
	<title></title>
	 <link href="Bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
		<link href="Bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet"/>
		<script src="Bootstrap/jquery-2.1.4/jquery.min.js" type="text/javascript"></script>
		<script src="Bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		
		<link href="jqui/jquery-ui.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/loginstyle.css" />
		<script type="text/javascript" src="js/jquery-2.0.2.js" ></script>
		<script type="text/javascript" src="jqui/jquery-ui.js" ></script>
		<script type="text/javascript" src="js/jquery.validate.js" ></script>
		<script type="text/javascript" src="js/loginindex.js"></script>

<style type="text/css">
		body{
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
			.box2{
				margin: 30px 0px;
			}
			.register{
				margin-left:30%;
				
				margin-right:30%;
			}
				footer{
			background: rgba(45,45,48,0.9);
			color:#bdbdbd;
			margin-top: 110px;
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
		    		<a href="#" >1.进行注册</a> 
		    	</div>
		    	<div class="col-md-3" >
		    		<a href="#" class="active"> 2.审核中</a>
		    	</div>
		    	<div class="col-md-3">
		    		<a href="#" >3.审核成功</a>
		    	</div>
		    </div>
			
			<div class="box2 row">
					<div class="col-md-2"> </div>
					<div class="col-md-5">
						<strong class="f16">感谢注册，我们正在加速为你审核你的信息 : <br /></strong>
						<p class="c7b">敬请等待。</p>
						<p><font color="red"> ${msg}
						</font></p>
	
						<p class="c7b mt20">没有审核通过？</p>
						<p>1. 请检查邮箱地址是否正确。</p>
						<p>2. 请检查选项是否正确</p>
						<p>3. 若仍未收到确认，请尝试 <a href="#" class="c46"></a></p>
						<p><a href="shenhe.action?id=${user.id}" class=" btn btn-primary">刷新审核</a></p>
					</div>
			</div><!-- // step2 end -->
			
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