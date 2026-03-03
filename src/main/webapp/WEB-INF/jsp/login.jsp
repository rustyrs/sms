<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="css/login.css" />
</jsp:include>

<h2>Student Management System</h2>

<div id="login">
	<form action="login" method="post" id="manager" class="card">
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
