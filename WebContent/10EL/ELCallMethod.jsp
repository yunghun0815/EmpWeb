<%@page import="java.util.List"%>
<%@page import="kr.kosa.common.MyELClass"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	tr, td{
		border: 1px solid black;
		padding: 5px 10px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MyELClass myClass = new MyELClass();
	pageContext.setAttribute("myClass", myClass);
	
	List<String> list = myClass.showGugudan(7);
	pageContext.setAttribute("list", list);
%>
<body>
	<h3>영역에 저장 후 메서드 호출하기</h3>
	001225-3000000 => ${myClass.getGender("001225-3000000") }<br>
	001225-2000000 => ${myClass.getGender("001225-2000000") }<br>
	
	<h3>클래스명을 통해 정적 메서드 호출하기</h3>
	<table>
		<c:forEach var ="i" begin="1" end="${list.size()/9}" >
			<tr>
				<c:forEach var = "j" begin="${(i-1)*9}" end="${i*9-1}">
					<td>${list[j]}</td>
				</c:forEach>
			</tr>
		</c:forEach>
<%-- 		<c:forEach items="${list}" var = "result">
			<tr>
				<td>${result }</td>
			</tr>
		</c:forEach> --%>
	</table>
</body>
</html>