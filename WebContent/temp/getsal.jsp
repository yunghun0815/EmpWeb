<%@page import="kr.kosa.emp.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원 급여</h1>
<%
	EmpDao dao = new EmpDao();
	int result = 0;
	String empStr = request.getParameter("empId");
	if(empStr != null){
		result = dao.getSalaryByEmployeeId(Integer.parseInt(empStr));
		out.println("<h1>"+ empStr +"번 사원의 급여는 "+ result + "</h1>");
	}else{
		out.print("<h1>empId를 추가해주세요</h1>");
	}
%>
</body>
</html>