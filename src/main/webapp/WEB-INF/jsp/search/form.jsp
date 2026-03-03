<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>

<h2>学生検索</h2>

<form action="search" method="post">
	お名前:<br><br>
	<input type="text" name="name" class="input">
	<br><br>
	<input type="submit" value="検索" class="button">
</form>

<%@include file="../common/footer.jsp" %>