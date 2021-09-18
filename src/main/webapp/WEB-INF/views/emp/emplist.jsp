<%@page import="com.ptw.model.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp list</title>
<%-- <link href="${pageContext.request.contextPath}/static/styles.css" rel="stylesheet" type="text/css"> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
table, td, tr{
border : 1px solid black;
}

</style>

<script>
$(document).ready(function(){
  $("#empbutton").click(function(){
    $("#here").load("/springtest/emplist.do");
  });
  
  $("#deptbutton").click(function(){
	    $("#here").load("/springtest/deptlist.do");
	  });
  
});
</script>


</head>
<body>

<!-- 선택된 페이지에 불러와서 지정된 페이지를 넣어준다.  -->
<!-- 표준액션 : 컴파일 후에 합친다.  -->
<jsp:include page="../common/header.jsp"></jsp:include>

<br>
<button id="empbutton">emplist</button>
<button id="deptbutton">deptlist</button>


<h1>직원목록 로그인정보 : ${loginEmail} </h1>
<a href="empInsert.do">신규등록 </a>
<br><br>
<%-- <ul>
  <li>문자값:${myname}</li>
  <li>숫자값:<%=request.getAttribute("myscore") %></li>
  <li>emp객체:${myemp}</li>
  <li>info객체:${info}</li>
  <li>${appInfo}</li>
</ul> --%>

<table>
  <tr>
     <td>직원번호</td>
     <td>성</td>
     <td>이름</td>
     <td>이메일</td>
     <td>폰</td>
     <td>입사일</td>
     <td>jobid</td>
     <td>급여</td>
     <td>commission</td>
     <td>managerid</td>
     <td>departmentid</td>
     <td>삭제</td>
     </tr>


<c:forEach var="emp" items="${emplist}">
	<c:url value="empDetail" var ="empD">
		<c:param name="empid" value="${emp.employee_id}"></c:param>
	</c:url>
   <tr>
    <td><a href ="empDetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
    <td>
    ${fn:toUpperCase(emp.first_name)}</td>
    <td>${emp.last_name} </td>
    <td>${emp.email}</td>
    <td>${emp.phone_number}</td>
    <td>
    <fmt:formatDate pattern="YYYY-MM-DD" value="${emp.hire_date}"/><!--  hh:mm:ss -->
    </td>
    <td>
    <fmt:formatNumber type="currency" currencySymbol="$" groupingUsed="true" value="${emp.salary}"/>
    </td>
    <td>${emp.job_id}</td>
    <td>${emp.commission_pct}</td>
    <td>${emp.manager_id}</td>
    <td>${emp.department_id}</td>
    <td><button onclick="call(${emp.employee_id});">삭제</button></td>
  </tr>
</c:forEach>

</table>

<%-- 디렉티브태그 :합쳐서 컴파일한다. --%>

<%-- <c:set var="cPath" value="${pageContext.request.contextPath}"/> --%>
<%-- <jsp:include page="../common/footer.jsp"></jsp:include>  --%>



<%-- 컴파일전에 경로에서 파일을 찾아서 합친다.경로오류 --%>
<%-- <%@ include file="${cPath}/common/footer.jsp" %>  --%>



<jsp:include page="../common/footer.jsp"></jsp:include>

<script>
function call(empid){
	location.href="empDelete.do?empid=" + empid;
}
</script>
</body>
</html>