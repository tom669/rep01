<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script  src="js/jquery-1.12.4.js"></script>
<script  src="js/ajaxdemo.js"></script>
</head>
<body>
    <!-- 
        用户名，密码 (确认密码)
     -->
       <form action="register"  method="POST" >
           用户名:<input name="username"/>
           <span>用户名英文字母开头数字字母下划线组成,6~12个字符</span>
            <br/>
           密码:<input type="password" name="password"/>
            <span>数字字母下划线组成6~10个字符</span>
            <br/>
            确认密码:<input type="password"  name="password2"/> 
             <span>两次输入密码必须一致</span>
            <br/> 
            <input type="button"  value="注册"/>  
       </form>
     <script type="text/javascript">
          //表单验证
            $(function(){
            	  //页面加载完毕后再执行
            	  $("[name=username]").blur(checkUsername);
            	  $("[name=password]").blur(checkPassword);
            	  $("[name=password2]").blur(checkRepeat);
            	  $("[type=button]").click(function(){
            		    if(!bl){
            		    	return;//用户名没有验证通过，阻止表单提交
            		    }
           		  
            		     //提交表单
            		     //三个框都合法，才能提交
            		     if(checkPassword() && checkRepeat()){
            		    	   $("form").submit();
            		     }
            	  });
            	  
            	  
            	  
            	  //检查确认密码
            	  function checkRepeat(){
            		  //获得密码框的值
            		  var pass1 = $("[name=password]").val().trim();
            		  //获得确认密码框的值
            		  var pass2 = $("[name=password2]").val().trim();
            		  if(pass1 === pass2){
            			   //合法
            			   $("[name=password2]").next().html("密码一致").css({color:"green",fontWeight:"900"});
            			   return true;
            		  }else{
            			 //不合法
            			  $("[name=password2]").next().html("密码不一致").css({color:"red",fontWeight:"900"});
            		      return false;
            		  }
            	  }
            	  
            	  //检查密码
            	  function checkPassword(){
            		  var password = $("[name=password]").val().trim();
            		  var reg = /^\w{6,10}$/;
            		  if(reg.test(password)){
            			  //合法
            			  $("[name=password]").next().html("密码合法").css({color:"green",fontWeight:"900"});
            			  return  true;
            		  }else{
            			  //不合法
            			  $("[name=password]").next().html("密码不合法").css({color:"red",fontWeight:"900"});
            			  return  false;
            		  }
            	  }
            	  
            	  var bl = false;
            	  //检查用户名
            	  function checkUsername(){
            		  var username = $("[name=username]").val().trim();
            		  var reg = /^[A-Za-z]\w{5,11}$/;
            		  if(reg.test(username)){
            			  //合法
            			  //$("[name=username]").next().html("用户名合法").css({color:"green",fontWeight:"900"});
            			 //做ajax验证
            			  doAjax('POST','checkRegName','username='+username,function(data){
            				    //data=="OK" 用户名可以用
            				    //data=="FAIL" 用户名被占用
            				    console.log(data);
            				    if(data=="OK"){
            				    	$("[name=username]").next().html("用户名可用").css({color:"green",fontWeight:"900"});
            				    	bl =  true;
            				    }else{
            				    	$("[name=username]").next().html("用户名被占用").css({color:"red",fontWeight:"900"});
            				    	bl =  false;
            				    }
            			  });
            		  }else{
            			  //不合法
            			  $("[name=username]").next().html("用户名不合法").css({color:"red",fontWeight:"900"});
            		      bl = false;
            		  }
            	  }            	
            });
     
     </script>
</body>
</html>