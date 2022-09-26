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
	<a href="emp?cmd=empcount">모든 사원의 수</a><br>
	<a href="emp?cmd=empcount&deptid=50">50번 부서의 사원 수</a><br>
	<a href="emp?cmd=getdept&empid=100">100번 사원의 부서번호</a><br>
	<a href="emp?cmd=avgsal&deptid=50">50번 부서의 평균 급여</a><br>
	<a href="emp?cmd=empsal&empid=100">100번 사원의 급여</a><br>
	<a href="emp?cmd=empdetail&empid=100">100번 사원의 정보</a><br>
	
	<h1>사원 관리</h1>
	<a href="EmpList.do">사원목록 조회</a>
	<a href="EmpInsert.do">사원 등록</a>
	
	<h1>컨트롤러 테스트</h1>
	<a href="test">테스트</a>
	<a href="test/test1">테스트1</a>
	<a href="test/test2">테스트2</a>
	<a href="test/test3">테스트3</a>
</body>
</html>