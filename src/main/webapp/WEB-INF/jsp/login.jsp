<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students Management System</title>
<link rel="stylesheet" href="<c:url value='/css/login.css' />">
</head>
<body>

<h2>Student Management System</h2>

<div id="login">
	<form action="login" method="post" id="student" class="card">
		<h3>学生</h3>
		学生番号<br>
		<input type="text" name="number"><br>
		パスワード<input type="password" name="password"><br>
		<br>
		<br>
		<input type="submit" value="    " class="submit"><br>
		<c:if test="${studentUnsuccess}">ログインに失敗しました</c:if>
	</form>
	
	<form action="login" method="post" id="manager" class="card">
		<h3>管理者または教員<h3>
		ID<br>
		<input type="text" name="id"><br><br>
		パスワード<input type="password" name="password"><br>
		<br>
		<input type="submit" value="    " class="submit"><br>
		<c:if test="${managerUnsuccess}">ログインに失敗しました</c:if>
	</form>
</div>

</body>
</html>
