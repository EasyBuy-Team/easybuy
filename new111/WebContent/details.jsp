<%@page import="com.entity.Answer"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Questions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="saveAnswer.do" method="post">
		<table>
			<tr>
				<td>问题：</td>
				<% Questions qt=(Questions)request.getAttribute("questions"); %>
				<td><%= qt.getTitle() %></td>
			</tr>
			
			<tr>
				<td>问题描述： <input type="hidden" name="id" value=<%= qt.getQid() %>></td>
				<td><%= qt.getDetailDesc() %></td>
			</tr>
			<%
				List<Answer> list=(List<Answer>)request.getAttribute("anList");
				int size=list.size();
			%>
			<tr>
				<td rowspan="<%= size %>">网友回答：</td>
			</tr>
			
			<tr>
				<% for(Answer ans:list){ %>
				
				<td><%= ans.getAnsDate() %><br/>
					<%= ans.getAnsContent() %>
				</td>
				
				<% } %>
			</tr>
			
			<tr>
				<td>我来回答：</td>
				<td><textarea cols="20" rows="5" name="ansContent"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交答案"> <a href="questionQuery.do">返回首页</a></td>
			</tr>
		</table>
	</form>
</body>
</html>