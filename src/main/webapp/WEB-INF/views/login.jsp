<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="../css/login.css" /> -->
<!-- <link rel="stylesheet" type="text/css" href="css/login.css" /> -->
<!-- <link rel="stylesheet" type="text/css" href="/css/login.css" /> -->
<!-- <link rel="stylesheet" type="text/css" href="/WEB-INF/css/login.css" /> -->
<link rel="stylesheet" type="text/css" href="WEB-INF/css/login.css" />
<title>Login</title>
</head>
<body>
	<form method="GET" action="/main" class="login">
	    <p>
	      <label for="login">Логин:</label>
	      <input type="text" name="login" id="login" value="name@example.com">
	    </p>
	
	    <p>
	      <label for="password">Пароль:</label>
	      <input type="password" name="password" id="password" value="4815162342">
	    </p>
	
	    <p class="login-submit">
	      <button type="submit" class="login-button">Войти</button>
	    </p>
	</form> 
	<p id="war">${warning}</p> 
</body>
</html>