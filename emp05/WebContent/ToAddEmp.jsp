<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <form action="save"  method="POST">
        姓名:<input name="ename"/><br/>
        性别:<label>
                      <input type="radio" name="esex" value="男" checked/> 男
                </label>
                <label>
                      <input type="radio" name="esex" value="女" /> 女
                </label>
         <br/>
         年龄:<input name="eage"/> <br/>
         薪资:<input name="esalary"/> <br/>
    <!--      部门编码:<input name="deptno"/> -->
          部门:<select name='deptno'>
                <option value='-1'>---请选择---</option>
                <c:forEach items="${depts}"  var="d">
                     <option value='${d.deptno}'>${d.dname}</option>
                </c:forEach>
            </select>
           <br/>
 <!--          经理编号:<input name="mgrno"/> <br/>    -->    
            经理:<select name='mgrno'>
                 <option value='-1'>---请选择---</option>
                 <c:forEach items="${mgrs}"  var="m">
                     <option value='${m.empno}'>${m.ename}</option>
                 </c:forEach>
            </select>
          <br/>
         <input type="submit" value="保存"/>
     </form>
</body>
</html>