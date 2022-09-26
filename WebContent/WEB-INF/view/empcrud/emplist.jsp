<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	th, td{
		border: 1px solid black;
		padding: 0 10px;
	}
</style>
</head>
<body>
	<h1>사원 정보 입력 양식</h1>
	<a href="EmpInsert.do">신규 사원 정보 입력</a>
	<table>
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>성</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>입사일</th>
			<th>직업</th>
			<th>급여</th>
			<th>커미션</th>
			<th>관리자번호</th>
			<th>부서번호</th>
		</tr>
		<c:forEach items="${list}" var="result">
			<tr>
				<td><a href="emp?cmd=empdetail&empid=${result.employeeId}">${result.employeeId}</a></td>
				<td>${result.firstName }</td>
				<td>${result.lastName }</td>
				<td>${result.email }</td>
				<td>${result.phoneNumber }</td>
				<td>${result.hireDate }</td>
				<td>${result.jobId }</td>
				<td>${result.salary }</td>
				<td>${result.commissionPct }</td>
				<td>${result.managerId }</td>
				<td>${result.departmentId }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>