<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>

<script>
	$.ajax({
		url : "getjson",
		type : 'Post',
		success : function(data, textStatus) {
			alert('OK!!');
			console.log(data);
    
		},
		error : function(data, textStatus, errorThrown) {
			console.log(data);
			
		},
	});
</script>


<body>


</body>
</html>