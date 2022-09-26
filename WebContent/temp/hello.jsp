<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>모든 사원의 수는 <% 
		out.println(request.getAttribute("cnt"));
	%></h1>
	<h2>모든 사원의 수는 <%= request.getAttribute("cnt") %></h2>
	<h3>모든 사원의 수는 ${cnt}</h3>
</body>
</html>