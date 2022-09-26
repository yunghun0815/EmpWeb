<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	//예시에서 사용할 변수 선언
	pageContext.setAttribute("num1", 9);
	pageContext.setAttribute("num2", 10);
	
	pageContext.setAttribute("nullStr", null);
	pageContext.setAttribute("emptyStr", "");
	pageContext.setAttribute("lengthZero", new Integer[10]);
	pageContext.setAttribute("lengthZero2", 0);
	pageContext.setAttribute("sizeZero", new ArrayList());
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>empty 연산자</h3>
	empty nullStr : ${empty nullStr }<br>
	empty emptyStr : ${empty emptyStr }<br>
	empty lengthZero : ${empty lengthZero }<br>
	${lengthZero} <Br>
	empty lengthZero2 : ${empty lengthZero2 }<br>
	${lengthZero2} <Br>
	empty sizeZero : ${empty sizeZero }<br>
	
	<h3>삼항 연산자</h3>
	num1 gt num2 ? "참" : "거짓" => ${num1 gt num2 ? "num1이 크다" : "num2가 크다"}
	
	<h3>null 연산자</h3>
	null + 10 : ${numm + 10 }<br>
	nullStr + 10 : ${nullStr + 10 }<br>
	param.noVal > 10 : ${param.noVar > 10 }
</body>
</html>