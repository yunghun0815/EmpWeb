<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>------------------------</h2>
	<h2> c:set 태그</h2>
	<c:set var="name" value="홍길동" scope="request"></c:set>
	<%
		//request.setAttribute("name", "홍길동");
	%>
	<h1>${name }</h1>
	<c:remove var="name" scope="request"/>
	<%
		//request.removeAttribute("name");
	%>
	
	
	<h2>------------------------</h2>
	<h2> c:if 태그</h2>
	<c:if test="${empty name}">
		<h1>이름 데이터가 없습니다.</h1>
	</c:if>
	<c:if test="${not empty name}">
		<h1>${name }</h1>
	</c:if>
	
	
	<h2>------------------------</h2>
	<h2> c:choose, when, otherwise 태그</h2>
	<c:set var="age" value="10"></c:set>
	<c:choose>
		<c:when test="${age >= 20}">성인입니다.</c:when>
		<c:when test="${age <= 7}">유아입니다.</c:when>
		<c:otherwise>기타입니다.</c:otherwise>
	</c:choose>
	
	
	<h2>------------------------</h2>
	<h2> c:forEach 태그</h2>
	<c:forEach var="i" begin="0" end="9">
		<span>${i}</span>
	</c:forEach>
	
	
	<h2>------------------------</h2>
	<h2> c:forEach 향상된 for문</h2>
	<%
		List<String> data = new ArrayList<>();
		for(int i=1; i<=10; i++){
			data.add("글"+i);
		}
		request.setAttribute("data", data);
	%>
	<c:forEach items="${data}" var="data">
		<span>${data}</span>
	</c:forEach>
	
	<h2>------------------------</h2>
	<h2> c:forTokens 태그</h2>
	<%
		String strArr = "홍길동1, 홍길동2, 홍길동3, 홍길동4";
		request.setAttribute("strArr", strArr);
	%>
	<c:forTokens var="str" items="${strArr}" delims=",">
		<span>${str}</span>
	</c:forTokens>	
	
	<h2>------------------------</h2>
	<h2> c:import 태그</h2>
<%-- 	<%@ include file = "../../10EL/Operator2.jsp" %>
	<jsp:include page="../../10EL/Operator2.jsp"></jsp:include> --%>
	<%-- <c:import url="https://www.naver.com"></c:import> --%>
	
	
	<h2>------------------------</h2>
	<h2> c:url 태그</h2>
	<a href='<c:url value="/emp?cmd=empdetail&empid=100"/>'>103번 사원 정보</a>
</body>
</html>