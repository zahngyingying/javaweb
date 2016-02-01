<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
</head>
<body>
<form action="register" method="post">
      用户名：<input type="text" id="username" name="username"/> 
      密   码：<input type="password" id="password" name="password"/>
      <input type="submit" id="register"name="register"value="完成"/>
      <br/>
      ${mess1}
      
      
</form>
</body>
</html>