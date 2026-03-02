<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:choose>
	<c:when test="${isExists}">ログイン成功</c:when>
	<c:when test="${!isExists}">ログイン失敗</c:when>
	<c:otherwise>エラー</c:otherwise>
</c:choose>

<%@include file="../common/footer.jsp" %>