<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<h1>직원정보 상세보기</h1>


<form action="empInsert.do" method="post">
employee_id : <input type="number" name="employee_id"><br>
first_name : <input type="text" name="first_name"><br>
last_name : <input type="text" name="last_name"><br>
email : <input type="text" name="email"><br>
phone_number : <input type="text" name="phone_number" value="010.7708.7777"><br>
hire_date : <input type="text" name="hire_date" value="2021-04-20"><br>
job_id : <input type="text" name="job_id" value="IT_PROG"><br>
salary : <input type="number" name="salary" value="8000"><br>
commission_pct : <!-- <input type="text" name="commission_pct" value="0.1"><br> -->
manager_id : <input type="number" name="manager_id" value="100"><br>
department_id : <input type="number" name="department_id" value="50"><br>

<input type= "submit" value="입력하기">



</form>
</body>
</html>