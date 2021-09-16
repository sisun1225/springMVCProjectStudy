<%@page import="com.ptw.model.DeptVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
  table, td{border: 1px solid black; border-collapse: collapse;}
  td {padding : 5px;}
  tr:first-of-type{background-color: hotpink;}
  
  #here{
  border: 1px solid red;
  }
</style>



</head>
<body>

<jsp:include page="../common/header.jsp"></jsp:include>


<div id="here">

<h5>emp 리스트</h5>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
	<form action="${cpath}/emp/selectByDeptmany.do">
		<select name ="deptlist" multiple="multiple" size="10">
			<c:forEach items="${deptall}" var="dept">
				<option value="${dept.department_id}">${dept.department_name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="여러부서 직원 조회">
	</form>


<h1>부서목록</h1>

<!-- <a href="deptInsert.do">신규등록</a> -->

<hr>
<table>
  <tr>
    <td>부서코드</td><td>이름</td><td>메니져</td><td>지역코드</td><td></td>
  </tr>
  
 	<c:forEach var="dept"  items="${deptall}">
    <tr>
    <td><a href="deptDetail.do?i_deptid=${dept.department_id}">${dept.department_id}</a></td>
    <td>${dept.department_name}</td>
    <td>${dept.manager_id}</td>
    <td>${dept.location_id}</td>
    <td><button onclick="call(${dept.department_id})">삭제</button></td>
  </tr>
	</c:forEach>
</table>


</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
	
	<script>
		function call(deptid){
			location.href="deptDelete.do?deptid=" + deptid;
		}
	</script>
</body>
</html>