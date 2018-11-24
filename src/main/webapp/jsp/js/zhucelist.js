
/*!
 * @名称：注册检测
 * @功能：对表单进行检测
 * @作者：董瑞
 * @日期：2018-06-27
 */

$(document).ready(function (){
	
	var hosts=['qq.com','163.com','126.com','gmail.com','sina.com','hotmail.com'];
	//自动补全：数据源用Function(request,response)
	//request：可以取到用户输入的信息
	//re4aponse:返回新的数据源，自动更新自动补全下拉列表
	$("#email").autocomplete({
		autoFocus:true,
		delay:0,
		source:function(request,response){
		  //1获取用户输入的文本信息，并根据输入的信息提取出name,host
		var term=request.term;
		//找到@在term中的位置
		//indexOF()：如果未找到，返回-1；如果找到了，返回具体的位置(index>=0)
		var ix=term.indexOf('@');
		var name='';
		var host='';
		var result=[];
		var findedHosts=[];
		var findedResult=[];
		
		result.push(term);
		
		if(ix<0){
			//没有找到@，则表示用户输入的信息全部都是name，host值为空
			name=term;
			host='';
		}else{
			//已经找到@，则表示用户正在开始输入域名部分
			name=term.slice(0,ix);
			host=term.slice(ix+1);
		}
		//2.根据host值对hosts数据进行过滤筛选
		if(name){
			
//			if(host){
//				findedHosts=$.grep(hosts,function(value,index){
//					return value.indexOf(host)>-1;
//				});
//			}else{
//				//当host为空，不需要对hosts数组进行筛选
//				findedHosts=hosts;
//			}
			
			findedHosts=(host)?$.grep(hosts,function(value,index){
						return value.indexOf(host)>-1;
						}):hosts;
			
			findedResult=$.map(findedHosts, function(value,index){
				return name+'@'+value;
			});
			
			result = result.concat(findedResult);
		}
		  response(result);
	    }
	});
	
	$('.register').validate({
		rules : {
			loginName : {
				required : true,
				rangelength : [2,10],
// 				remote : {
// 					url:"check",
// 					type:"POST",
// 					dataType : "json",
// //					data : {
// //						name: function(){
// //							return $('#name').val();
// //						}
// //					}
// 					data : {
// 						value: function(){
// 							return $('#loginName').val();
// 						},
// 						type: function(){
// 							return "loginName";
// 						}
// 					}
// 				},
			},
            phone : {
                required : true,
                rangelength : [11,11],
            },
            idCard : {
                required : true,
                rangelength : [18,18],
            },
			email : {
				required : true,
				email: true,
// 				remote :  {
// 					url:"check",
// 					type:"POST",
// 					dataType : "json",
// //					data : {
// //						name: function(){
// //							return $('#name').val();
// //						}
// //					}
// 					data : {
// 						value: function(){
// 							return $('#email').val();
// 						},
// 						type: function(){
// 							return "email";
// 						}
// 					}
// 				},
			},
			password0 : {
				required : true,
				rangelength : [6,10],
			},
			password : {
				equalTo : '#password0',
			},
			birth : {
				required : true,
				date : true,
			}
		},
		messages : {
            phone : {
				required : '手机号不得为空！',
				rangelength :'手机号的长度必须是11位！',
			},
            idCard : {
                required : '身份证号码不得为空！',
                rangelength :'身份证号码的长度必须是18位！',
            },
            loginName : {
                required : '账号不得为空！',
                rangelength :'账号的长度必须是{0}至{1}之间！',
                // remote:"该账号已经被占用！",

            },
			email : {
				required : '邮箱不得为空！',
				email: '邮箱格式不对！',
				// remote:"该邮箱已经被占用！",
			},
			password0 : {
				required : '密码不得为空！',
				rangelength :'密码的长度必须是{0}至{1}之间！',
			},
			password : {
				equalTo : '两次输入的密码不一致！',
			},
			birth : {
				required : '生日不得为空！',
				date : '格式不正确！',
			}
		},
	});
});