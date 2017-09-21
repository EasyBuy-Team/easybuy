<%@page import="com.dao.GoodsDao"%>
<%@page import="com.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Product> products = GoodsDao.getAllProducts();
		request.setAttribute("products",products);
	%>
	
	<div style="width:600px;">
		<table border="1" width="80%">
			<!-- 标题信息 -->
			<tr>
				<th>商品名称</th>
				<th>产地</th>
				<th>价格</th>
			</tr>
			<!-- 循环输出商品信息 -->
			<c:forEach items="${requestScope.products}" var="product" varStatus="status">
				<tr <c:if test="${status.index % 2==1}">style="background-color:rgb(219,241,212)"</c:if>>
					<td>${product.name}</td>
					<td>${product.area}</td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
			
			
		</table>
	</div>
</body>
</html>