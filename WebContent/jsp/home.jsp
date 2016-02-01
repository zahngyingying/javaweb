<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>home</title>
</head>
<body>
       用户名：${username }
	    <form id="home" action="Servlet?po='home'" method="post">
		<h1>Hello World</h1>
		<p>欢迎${username}访问home页面！</p>
	</form>
</body>
</html>