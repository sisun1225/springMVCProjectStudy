<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원정보 상세보기</h1>

//
<jsp:include page="../common/header.jsp"></jsp:include>

<form id="myfrm" action="empDetail.do" method="post">

employee_id : <input type="number" name="employee_id" value="${emp.employee_id}"><br>
First_name : <input type="text" name="first_name" value="${emp.first_name}"><br>
Last_name : <input type="text" name="last_name" value="${emp.last_name}"><br>
Email : <input type="text" name="email" value="${emp.email}"><br>
Phone_number : <input type="text" name="phone_number" value="${emp.phone_number}"><br>
Hire_date : <input type="text" name="hire_date" value="${emp.hire_date}"><br>
Job_id : <input type="text" name="job_id" value="${emp.job_id}"><br>
Salary : <input type="number" name="salary" value="${emp.salary}"><br>
Commission_pct : <input type="text" name="commission_pct" value="${emp.commission_pct}"><br>
Manager_id : <input type="number" name="manager_id" value="${emp.manager_id}"><br>
Department_id : <input type="number" name="department_id" value="${emp.department_id}"><br>

<input type= "submit" value="수정하기">
<input type= "button" id="btnUpdate" value="수정하기2">
<input type= "button" id="btnUpdate2" value="수정하기(rest)">
<input type= "button" id="btnRetrieve" value="조회하기">
<input type= "button" id="btnDelete" value="삭제하기" mydata="${emp.employee_id}">

<input type= "button" id="btnDelete2" value="삭제하기(rest)" mydata="${emp.employee_id}">


</form>
 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#btnUpdate").on("click", function(){
		$("#myfrm").submit();
	});
	$("#btnRetrieve").on("click", function(){
		location.href="emplist.do";
	});
	$("#btnDelete").on("click", function(){
	alert($(this).attr("mydata"));
		location.href="empDelete.do?empid=" +(this).attr("mydata");
	});
	
	$("#btnDelete2").on("click", function(){
		alert($(this).attr("mydata"));
			var url="${pageContext.request.contextPath}/empDelete.do/"+$(this).attr('mydata');
			$.ajax({
				"url" :url,
				type:"delete",
				success:function(responseData){
					alert(responseData)
				}
			});
	
	});
	
	
	
	$("#btnUpdate2").on("click", function(){
		  var emp = $("#myfrm").serializeArray(); 
		  
		  var object = {};
		  for (var i = 0; i < emp.length; i++){
		      object[emp[i]['name']] = emp[i]['value'];
		  }
		  var json = JSON.stringify(object);
			alert(json);
	 	  $.ajax({url:"${pageContext.request.contextPath}/empUpdate.do",
	 		  type:"put", 
	 		  data:json, 
	 		  contentType:"application/json",
		         success:function(responseData){
		        	 alert(responseData);}
		         });
		 	});
	});

</script>

</body>
</html>