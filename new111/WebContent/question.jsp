<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>我&nbsp;要&nbsp;提&nbsp;问</h2>
	<a href="">返回首页</a>
	<form action="as.do" method="post">
		<table>
			<tr>
				<td>问题：</td>
				<td><input type="text" name="questions"></td>
			</tr>
			
			<tr>
				<td>问题描述：</td>
				<td><textarea name="questionDesc"></textarea></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="保存问题"></td>
			</tr>
		
		</table>
	
	
	</form>
</body>	
</html>