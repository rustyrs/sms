<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h2>学生追加</h2>

<c:choose>
	<c:when test="${result}">登録に成功しました</c:when>
	<c:when test="${!result}">登録が失敗しました</c:when>
</c:choose>

<%@include file="common/footer.jsp" %>