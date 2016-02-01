<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script type="text/javascript">
function register() {
	window.location.href="register.jsp";
	
}
</script>
</head>
<body>
<form action="ServletTest" method="post">
     用户名：<input type="text" id="username" name="username" value="${username}"/>
     密   码：<input type="password" id="passwors" name="password"/>
     <input type="submit" name="submit" value="登录"/>
     <input type="button" value="注册" onclick="javascript:register();"/>
     <br/>

${mess}
${mess2}
</form>
</body>
</html>