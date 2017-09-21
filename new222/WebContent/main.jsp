<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty sessionScope.user}" var="isLogin" scope="page">
		跳到登录页面
	</c:if>
	
	<c:if test="${!isLogin}" var="isLogin" scope="page">
		<c:choose>
			<c:when test="${sessionScope.user.role eq 'admin'}">
				管理员主页
			</c:when>
			
			<c:when test="${sessionScope.user.role == 'p'}">
				人事主页
			</c:when>
			
			<c:when test="${sessionScope.user.role eq 't'}">
				程序员主页
			</c:when>
			<c:otherwise>
				财务主页
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>