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
<h1>데이터베이스 연결 테스트</h1>
<%
	EmpDao dao = new EmpDao();
	int result = 0;
	String deptStr = request.getParameter("deptno");
	if(deptStr == null){
		result = dao.getEmpCount();
	}else{
		int deptno = Integer.parseInt(deptStr);
		result = dao.getEmpCount(deptno);
	}
%>
	<h1>부서 사원 수 = <%= result %></h1>
	
	<p>부서 평균 급여 확인</p>
	<form action="avgsal.jsp">
		<input type="text" name="deptno" placeholder="부서번호를 입력하세요">
		<input type="submit" value="확인하기">
	</form>
</body>
</html>