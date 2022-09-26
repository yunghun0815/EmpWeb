<%@page import="kr.kosa.emp.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	EmpDao dao = new EmpDao();
	String deptStr = request.getParameter("deptno");
	int avgsalary= 0;
	if(deptStr == null){
		deptStr = "전체부서";
		avgsalary = dao.getAverageSalaryByDepartment();
	}else{
		avgsalary = dao.getAverageSalaryByDepartment(Integer.parseInt(deptStr));
	}
%>
<body>
<h1>부서번호 -> <%= deptStr %> </h1>
<h1>평균 급여 = <%= avgsalary %></h1>

</body>
</html>