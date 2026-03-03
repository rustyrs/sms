<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>

<h2>学生削除</h2>

<form action="delete" method="post">
	削除する生徒のID:<br>
	<input type="text" name="id" class="input">
	<br><br>
	<input type="submit" class="button"><br>
</form>


<%@include file="../common/footer.jsp" %>