<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<h2>In this application there are only three registered users.</h2>
<p>Administrator: name - Alex; login - alex@mail.ru; password - admin</p>
<p>User: name - Max; login - max@gmail.com; password - client</p>
<p>User: name - Alexandra; login - krav@gmail.com; password - client</p>
<p>Each user except the administrator can see only his claims. The administrator sees all the requests.</p>
<br><br>
<body>
	<form method="GET" action="/main" class="login">
	    <p>
	      <label for="login">Login:</label>
	      <input type="text" name="login" id="login" placeholder="alex@mail.ru">
	    </p>
	
	    <p>
	      <label for="password">Password:</label>
	      <input type="password" name="password" id="password" placeholder="admin">
	    </p>
	
	    <p class="login-submit">
	      <button type="submit" class="login-button">Войти</button>
	    </p>
	</form> 
	<p id="war">${warning}</p> 
</body>
</html>