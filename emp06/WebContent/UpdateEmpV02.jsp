<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

     <form action="save"  method="POST">
        姓名:<input name="ename"  value="${emp.ename}"/><br/>
        性别:
           <!-- choose 选择 -->
           <c:choose>
                <c:when test="${emp.esex eq '男' }">
                   <label>
                <input type="radio" name="esex" value="男"  checked/> 男
                </label>
                <label>
                      <input type="radio" name="esex" value="女" /> 女
                </label>
                </c:when>
              <c:when test="${emp.esex eq '女' }">
                 <label>
                <input type="radio" name="esex" value="男"  /> 男
                </label>
                <label>
                      <input type="radio" name="esex" value="女" checked /> 女
                </label>
              </c:when>
        </c:choose>
           
         <br/>
         年龄:<input name="eage"/> <br/>
         薪资:<input name="esalary"/> <br/>
         部门编码:<input name="deptno"/>
           <br/>
          经理编号:<input name="mgrno"/> <br/>       
          <br/>
         <input type="submit" value="保存"/>
     </form>
</body>
</html>