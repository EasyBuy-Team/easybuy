<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	function load(){
		$.ajax({
			url:"gson.do",
			type:"post",
			data:null,
			dataType:"json",
			success:function(result){
				var $str=$("<ul></ul>");
				for(var i=0;i<result.length;i++){
					$str.append("<li>"+result[i].qid+"&nbsp;&nbsp;&nbsp;"+result[i].title+"&nbsp;&nbsp;&nbsp;"+result[i].detailDesc+"&nbsp;&nbsp;&nbsp;"+result[i].answerCount+"&nbsp;&nbsp;&nbsp;"+result[i].lastModified+"</li>");
					$("div").append($str);
				}
			},
			error:function(){
				alert("出错啦！！！");	
			}
		 });
	}

</script>
</head>
<body>
	<input type="button" value="加载数据" onclick="load()"/>
	<div></div>
</body>
</html>