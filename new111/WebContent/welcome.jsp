<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Questions"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	function submitForm(pn){
		$("input[name=pageNo]").val();
		$("#form1").submit();
	}

</script>
</head>
<body>
<h2>在线问答</h2>
		<form id="form1" action="questionQuery.do" method="post">	
			<input type="hidden" name="pageNo"/>	
			问题<input type="text" name="title" value="${param.title}"/>&nbsp;&nbsp;最后修改时间<input type="text" name="modifyTime" value="${param.modifyTime}"/>
			<input type="submit" value="搜索"/>			
		</form>
		
		<table>
		
			<tr>
				<th>序号</th>
				<th>问题</th>
				<th>回答次数</th>
				<th>最后修改</th>
			</tr>
			
			<c:forEach items="${list}" var="qs">
			
		<tr>
			<td>${qs.qid}</td>
			<td><a href="updateAnswers.do?id=${qs.qid}">${qs.title}</a></td>
			<td>${qs.answerCount}</td>
			<td>${qs.lastModified}</td>
		</tr>
			</c:forEach>
		</table>
			<c:forEach begin="1" end="${pages}" step="1" var="i">
				<a href="javascript:void(0)" onclick="submitForm(${i})">${i}</a>
				<%-- <a style="color:red;" href="questionQuery.do?pageNo=${i}&title=${param.title}&modifyTime=${param.modifyTime}">${i}</a> --%>
			</c:forEach>
</body>
</html>