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

     <form action="update"  method="POST">
     <!-- 使用隐藏域 传递empno -->
        <input type="hidden"  name="empno"  value="${emp.empno}"/>
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
               <c:otherwise>
               <label>
                <input type="radio" name="esex" value="男"  /> 男
                </label>
                <label>
                      <input type="radio" name="esex" value="女" checked /> 女
                </label>               
               </c:otherwise>
        </c:choose>
           
         <br/>
         年龄:<input name="eage"  value="${emp.eage}"/> <br/>
         薪资:<input name="esalary" value="${emp.esalary}"/> <br/>
          部门:<select name='deptno'>
                <c:forEach items="${depts}"  var="d">
                    <c:if test="${emp.deptno eq d.deptno}">
                         <option value='${d.deptno}'  selected>${d.dname}</option>
                    </c:if>
                
                       <c:if test="${!emp.deptno eq d.deptno}">
                         <option value='${d.deptno}' >${d.dname}</option>
                    </c:if>
                </c:forEach>
           </select>
           <br/>
           经理:<select name='mgrno'>
                 <c:forEach items="${mgrs }"  var='m'>
                     <c:choose>
                         <c:when test="${emp.mgrno eq m.empno }">
                             <option value='${m.empno}'  selected>${m.ename}</option>
                         </c:when>
                         <c:otherwise>
                         <option value='${m.empno}'>${m.ename}</option>
                         </c:otherwise>
                     </c:choose>
                 
                       
                 </c:forEach>
           </select>
          <br/>
         <input type="submit" value="修改"/>
     </form>
</body>
</html>