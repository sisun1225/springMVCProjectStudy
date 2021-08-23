<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  .logininfo{border : 5px dotted green; float:right}
</style>



</head>
<body>





<a href="http://localhost:9090/springtest/emplist.do">emplist</a>
<a href="http://localhost:9090/springtest/deptlist.do">deptlist</a>

<!-- 
<div class="logininfo">
 	<c:if test="${emp != null }">
	<p>${username}가 로그인함.</p>
	<p><a href="../login/logout.kosta">로그아웃</a></p>
	</c:if>
	<c:if test="${emp == null }">
		<p>손님</p>
	<p><a href="../login/loginchk.kosta">로그인</a></p>
	</c:if>
	
	<hr>
	
	<c:choose>
	
		<c:when test = "${emp==null}">
		<p>손님</p>
		<p><a href="../login/loginchk.kosta">로그인</a></p>
		</c:when>
	
		<c:otherwise>
		<p>${username}가 로그인함.</p>
		<p><a href="../login/logout.kosta">로그아웃</a></p>
		</c:otherwise>
	
	</c:choose>
	</div>
	 -->

<p>여기는 헤더</p>
<hr>
</body>
</html>