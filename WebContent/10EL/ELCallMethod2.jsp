<%@page import="kr.kosa.common.MyELClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/myTagLib.tld" %>
<!DOCTYPE html>
<html>
<%
	MyELClass myClass = new MyELClass();
	pageContext.setAttribute("myClass", myClass);
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>파일 등록 후 정적 메서드 호출하기</h3>
	<ul>
		<li>mytag:isNumber("100") => ${mytag:isNumber("100") }</li>
		<li>mytag:isNumber("이백") => ${mytag:isNumber("이백") }</li>
	</ul>
</body>
</html>