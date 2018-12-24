<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'jsoupTest.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type= "text/javascript" src= "<%=basePath %>js/jquery-3.3.1.min.js"></script >
<script type="text/javascript">
$(document).ready(function(){
      $("#btnlogin").click(function(){
            var json = {  
                'name':$(':input[name=username]').val(),  
                'pwd':$(':input[name=password]').val(),
                'birthday':'2018-05-01'
                };
                var postdata = JSON.stringify(json);//json對象轉換json字符串  
                alert(postdata);  
                
                $.ajax({  
                type : 'POST',  
                contentType : 'application/json;charset=UTF-8',//注意類型  
                processData : false,  
                url : 'jsoupTest',  
                dataType : 'json',  
                data : postdata,  
                success : function(data) {  
                    alert('username : '+data.name+'\npassword : '+data.pwd);  
                },  
                error : function(err) {  
                    console.log(err.responseText);
                    alert(err.responseText);
                    
                }  
              }); 
      });
    });

</script>



</head>



<body>
	<form action="/jsoupTest" method="post">
		姓名：<input type="text" name="username"> <br>
		<br> 密碼： <input type="text" name="password"> <br>
		<br> <input type="button" value="登陸" id="btnlogin"> <input
			type="submit" value="登陸">
	</form>
</body>
</html>
