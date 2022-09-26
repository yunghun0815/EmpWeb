<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num1" value="12345" scope="page"></c:set>
	<h1>${num1}</h1>
	<!--숫자 포맷  -->
	<h1><fmt:formatNumber value="${num1}"></fmt:formatNumber></h1>
	<!--숫자 포맷, 세 자리마다 콤마  (default가 true)  -->
	<h1><fmt:formatNumber value="${num1}" groupingUsed="false"></fmt:formatNumber></h1>
	<!--  -->
	<h1><fmt:formatNumber value="${num1}" type="currency" currencySymbol="@"></fmt:formatNumber></h1>
	<h1><fmt:formatNumber value="${num1}" type="currency" currencyCode="GBP"></fmt:formatNumber></h1>
	<h1><fmt:formatNumber value="${num1}" type="currency" currencyCode="EUR"></fmt:formatNumber></h1>
	<h1><fmt:formatNumber value="${num1}" type="currency" currencyCode="JPY"></fmt:formatNumber></h1>
	<h1><fmt:formatNumber value="${num1}" type="currency" currencyCode="CAD"></fmt:formatNumber></h1>
	<h1><fmt:formatNumber value="${num1}" type="currency" currencyCode="CNY"></fmt:formatNumber></h1>
	<h1><fmt:formatNumber value="${num1}" type="currency" currencyCode="CHF"></fmt:formatNumber></h1>
	<h1><fmt:formatNumber value="${num1}" type="currency" currencyCode="KRW"></fmt:formatNumber></h1>
	
	<br><br>
	<h1>-----------parseNumber------------</h1>
	<c:set var="num2" value="6,600,789.101"></c:set>
	<fmt:parseNumber value="${num2}" pattern="#,#"></fmt:parseNumber>
	<fmt:parseNumber value="${num2}" pattern="###,###" var = "num3"/>
	<fmt:formatNumber value="${num3}" pattern="#,###.0##" />
	<%-- <fmt:parseNumber value="${num2}" integerOnly="true"></fmt:parseNumber> --%>
	<br>
	<c:set var="today" value="<%= new Date() %>"></c:set>
	<fmt:setLocale value="ko_KR"/>
	<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
	<fmt:formatDate value="${today}"/><br>
	
	<fmt:setLocale value="ja_JP"/>
	<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
	<fmt:formatDate value="${today}"/><br>
	
	<fmt:setLocale value="en_US"/>
	<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
	<fmt:formatDate value="${today}"/><br>
</body>
</html>