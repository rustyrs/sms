<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h2>学生更新</h2>

<c:choose>
	<c:when test="${result}">更新に成功しました</c:when>
	<c:when test="${!result}">更新に失敗しました</c:when>
</c:choose>


<%@include file="../common/footer.jsp" %>