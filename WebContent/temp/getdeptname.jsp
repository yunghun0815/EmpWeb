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
		String empidStr = request.getParameter("empid");
		String name = null;
		if(empidStr != null){
			name = dao.getDepartmentNameByEmployeeId(Integer.parseInt(empidStr));
			out.print("<h1>"+ empidStr+"번 사원의 부서 이름은 "+ name +"입니다</h1>");
		}else{
			out.print("empid를 입력해주세요");
		}
	%>
<body>
</body>
</html>