<%@page import="kr.kosa.emp.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>데이터베이스 연결 테스트</h1>
<body>
	<%
		EmpDao dao = new EmpDao();
		int result = dao.getEmpCount();
	%>
</body>
</html>