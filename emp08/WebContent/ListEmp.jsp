<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- 
      引入之前，现在WEB-INF/lib下添加两个jar包
           jstl.jar  standard.jar
      引入jsp 标准标签库
       prefix:设置标签的前缀,约定俗成写c
       
   -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    table{
       width:620px;
       border:3px solid #ccc;
       border-collapse: collapse;
       margin:auto;
       margin-top:20px;
    }
    
    table th,table td{
        border:1px solid #ccc;
    }
    
    div{
       text-align: center;
    }
    
    #logout{
       position: absolute;
       top:10px;
       right:10px;
    }
    
    table tr td{
        text-align: center;
    }
    
    .on{
       background: #ff6633;
    }
</style>
<script type="text/javascript">
       function changePage(n){
    	      //将表单 pageNo值修改为n
    	      document.frm.pageNo.value = n;
    	      //提交表单
    	      document.frm.submit();
       }
       

</script>
</head>
<body>
     <span id="logout"><a href="logout">退出登录</a></span>
     <center>
      <h1>天翼员工管理系统</h1>
      <h4>欢迎,${user.user_name}</h4>
     </center>
     <center>
     <form  name='frm' action="list" method="POST">
         <!-- 保留上一次的条件 -->
        员工姓名:<input name='condition'  value='${pb.condition}'/>
         <input name='pageNo' value='1'  type="hidden"/>
         <input type='submit'  value='搜索'/>
     </form>
     </center>
      <table>
          <tr>
           <!--  <th>员工编号</th> -->
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>薪资</th>
            <th>部门</th>
            <th>经理</th>
            <th>操作</th>
          </tr>
          <!-- 
              从request中将集合 emps取出
               forEach 遍历
                   遍历集合,等价于一个循环
                     每一次循环依次从集合中取出一个员工对象
                       给它命名为"e" (var属性定义的)
           -->
          <c:forEach items="${pb.list}"  var="e">
              <tr>
              <!--  e.ename 获取员工对象的ename属性值 -->
            <td>${e.ename}</td>
            <td>${e.esex}</td>
            <td>${e.eage}</td>
            <td>${e.esalary }</td>
            <!-- 等价于员工对象连续调用get方法
                 e.getDept().getDname()
             -->
            <td>${e.dept.dname}</td>
            <td>${e.mgr.ename}</td>
            <td>
               <c:if test="${!ms.getContain(e.empno)}">
               <a href="delete?empno=${e.empno}">删除</a>
               </c:if>
             <a href="toUpdate?empno=${e.empno}">修改</a>
             
            </td>
          </tr>
          </c:forEach>
      </table>
      <div>
         <a href="javascript:changePage(${pb.first});">首页</a>
         <a href="javascript:changePage(${pb.previous});">上一页</a>
        <!-- 遍历出页码 -->
          <c:forEach  begin="1"  end="${pb.totalPage}"  var="n">
                <c:choose>
                      <c:when test="${n==pb.pageNo}">
                         <a href="javascript:changePage(${n});"  class='on'>${n}</a>
                      </c:when>
                     <c:otherwise>
                        <a href="javascript:changePage(${n});" >${n}</a>
                     </c:otherwise>
                </c:choose>                  
          </c:forEach>
           <a href="javascript:changePage(${pb.next});">下一页</a>           
          <a href="javascript:changePage(${pb.last});">尾页</a>
      </div>
    <div>    
     <a href="toAdd">添加</a>
     </div>
</body>
</html>