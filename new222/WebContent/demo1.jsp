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
	<c:set var="option" value="总裁"/>
		<c:choose>
			<c:when test="${option eq '总监' }">
				总监
			</c:when>
			
			<c:when test="${option eq '总裁' }">
				总裁
			</c:when>
			<c:otherwise>
				员工	
			</c:otherwise>
		</c:choose>
</body>
</html>