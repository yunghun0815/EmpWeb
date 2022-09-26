
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
   <head>
      <title>JSTL x:out Tags</title>
   </head>

   <body>
      <h3>Books Info:</h3>

      <c:set var = "xmltext">
         <books>
            <book>
               <name>Padam History</name>
               <author>ZARA</author>
               <price>100</price>
            </book>
            <book>
               <name>Great Mistry</name>
               <author>NUHA</author>
               <price>2000</price>
            </book>
         </books>
      </c:set>
	<x:parse xml = "${xmltext}" var = "output"/>
	<x:out select="$output/books"/>
	<table>
		<tr><th>제목</th><th>저자</th><th>가격</th></tr>
		<x:choose>
			<x:when select="$output/books/book[1]/price >50">okay</x:when>
			<x:otherwise>no</x:otherwise>			
		</x:choose>
	 	<x:forEach select="$output/books/book" var="item">
			  <tr>
				<td><x:out select="$item/name"/></td>
				<td><x:out select="$item/author"/></td>
			</tr>  
		</x:forEach> 
	</table>
   
   </body>
</html>