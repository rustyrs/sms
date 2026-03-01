<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../../common/header.html" %>

<form action="delete" method="post">
	削除する生徒のID:
	<input type="text" name="id">
	
	<input type="submit">
</form>

<a href="menu">メニューへ</a>

<%@include file="../../common/footer.html" %>