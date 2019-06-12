/**
 *  doAjax 向服务器发送ajax请求
 *   type: GET POST
 *   url: 处理请求的Servlet的url-pattern 
 *   params:参数
 *   fn:回调函数,请求成功后，在页面如何做局部刷新
 */
function doAjax(type,url,params,fn){
	//获得对象
	  var xmlhttp;
	  if (window.XMLHttpRequest)
	    {// code for IE7+, Firefox, Chrome, Opera, Safari
	    xmlhttp=new XMLHttpRequest();
	    }
	  else
	    {// code for IE6, IE5
	    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	    }
	  //发送请求
	  if(type==="GET"){
		  xmlhttp.open("GET",url+"?"+params,true);
		  xmlhttp.send();
	  }else{
		   //POST
		  xmlhttp.open("POST",url,true);
		   //设置请求消息头
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(params);		  
	  }
	  //接收响应
	    xmlhttp.onreadystatechange=function()
	    {
	    if (xmlhttp.readyState==4 && xmlhttp.status==200)
	      {
	  	  //业务
	    	//txt 是服务器的回传文本
	         var txt=xmlhttp.responseText;
	         fn(txt);
	      }
	    }  
	  
	  
	  
	
}
