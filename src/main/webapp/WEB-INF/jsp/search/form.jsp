<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>

<h2>学生検索</h2>

<form action="search" method="post">
	お名前:
	<input type="text" name="name">
	
	<input type="submit">
</form>

<%@include file="../common/footer.jsp" %>