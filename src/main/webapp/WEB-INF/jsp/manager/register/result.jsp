<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../../common/header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:choose>
	<c:when test="${result}">登録に成功しました</c:when>
	<c:when test="${!result}">登録が失敗しました</c:when>
</c:choose>

<br>

<a href="menu">メニューへ</a>

<%@include file="../../common/footer.html" %>