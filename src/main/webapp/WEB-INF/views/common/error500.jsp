<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage = "true"%>
    <%
	 response.setStatus(200);    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 오류 입니다. </h1>
<hr>
<%=exception.toString() %>
<hr>
오류메세지 <%=exception.getMessage() %>
<hr>
<% exception.printStackTrace(); %>
</body>

</html>