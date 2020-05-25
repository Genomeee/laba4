<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List" %>
<%@page import="chnu.cv.web.*"  %>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table>
		<tr><th>Лабораторна робота №4</th></tr>
		<tr><th>
			<ol>
				<%
					List books = (List)request.getAttribute("books"); 
					if(books!=null)
					{
						for(int i = 0;i < books.size(); i++)
						{
							out.println("<li>"+ books.get(i)+ "</li>");
						}
					}
				%>
			</ol>  
		</th></tr>
	</table>
	
	<form action="BookServlet" method="GET">
		<label>Книжки за автором</label>
		<input type="text" id="author" name="author">
	</form>
</body>
</html>