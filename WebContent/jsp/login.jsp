<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>限定掲示板</title>
</head>
<body>
	<h2>限定掲示板</h2>

	<!--START Form-->
	<form action="<%=request.getContextPath()%>/login" method="post">

		ログインしないと書き込めません。<br>
		ユーザID：<input type="text" size="17" maxlength="10" name="id"><br>
		 パスワード：<input type="password" size="11" name="pass"><br>

			<input type="submit" name="btn" value="LOGIN">
	</form>

	<font color="red">${msg}</font>
	<c:remove var="msg" scope="session" />
</html>