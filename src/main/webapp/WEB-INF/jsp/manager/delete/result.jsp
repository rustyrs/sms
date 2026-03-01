<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../../common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:choose>
	<c:when test="${result}">削除に成功しました</c:when>
	<c:when test="${!result}">削除に失敗しました</c:when>
</c:choose>

<br>

<a href="menu">メニューへ</a>

<%@include file="../../common/footer.jsp" %>