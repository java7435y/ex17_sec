<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>限定掲示板</title>
</head>
<body>
	<c:if test="${empty id}">
		<c:redirect url="/jsp/login.jsp" />
	</c:if>

	<c:if test="${not empty id}">
		<h2>限定掲示板</h2>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table>
				<tr>
					<th>id：</th>
					<td>${id}</td>
				</tr>
				<tr>
					<th>メッセージ</th>
					<td><textarea name="message" rows="4" cols="20"></textarea></td>
				</tr>
			</table>
			<input type="hidden" name="id" value="${id}"> <input
				type="submit" name="btn" value="呟く">
		</form>
		<form action="<%=request.getContextPath()%>/logout" method="post">
			<input type="submit" value="LOGOUT">
		</form>
	</c:if>

	<c:if test="${not empty list}">
		<hr />
		<c:forEach var="bbs" items="${list}">
			<div style="border-style: solid;">
				${bbs.updDate}<br>
<span style="white-space:pre;">
ID:${bbs.usrid}[${bbs.msg}]
</span>
			</div>
		</c:forEach>

	</c:if>

</body>
</html>
