<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h1>사원 입력 양식</h1>
	<form action="EmpInsert.do" method="post">
		<table>
			<tr>
				<td>사원아이디</td>
				<td><input type="number" name="employeeId"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>성</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phoneNumber"></td>
			</tr>
			<tr>
				<td>입사일</td>
				<td><input type="date" name="hireDate"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="jobId">
						<c:forEach items="${jobIdList}" var="result">
							<option value="${result.jobId}">${result.jobTitle}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>급여</td>
				<td><input type="number" name="salary"></td>
			</tr>
			<tr>
				<td>보너스율</td>
				<td><input type="number" name="commissionPct" min="0" max="0.99" step="0.01"></td>
			</tr>
			<tr>
				<td>매니저아이디</td>
				<td>
					<select name="managerId">
						<c:forEach items="${empIdList}" var="result">
							<option value="${result.empId}">${result.name}(${result.empId})</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>부서번호</td>
				<td>
					<select name="departmentId">
						<c:forEach items="${deptIdList}" var="result">
							<option value="${result.deptId}">${result.deptName}(${result.deptId})</option>
						</c:forEach>
					</select>
				</td>
				
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>