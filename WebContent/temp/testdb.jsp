<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Array"%>
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
//		String url = application.getInitParameter("OracleURL");
//		String id = application.getInitParameter("OracleId"); 
//		String pw = application.getInitParameter("OraclePwd");
		EmpDao dao = new EmpDao();
		int result = dao.getEmpCount();
	%>
	<h2>사원의 수 : <%= result %></h2>
	
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>급여</th>
			<th>부서번호</th>
		</tr>
	<%
		ResultSet data = dao.getEmployeeId();
		
		while(data.next()){
			out.print("<tr><td>"+ data.getInt(1)+"</td><td>"+ 
								data.getString(2) +"</td><td>"+
								data.getInt(3)+"</td><td>"+
								data.getInt(4)+"</td></tr>");
		}
		
	%>
	</table>
</body>
</html>