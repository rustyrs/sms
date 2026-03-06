<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="/css/update.css" />
</jsp:include>

<h2>学生更新</h2>

<c:choose>
	<c:when test="${result}">
	<div id="success">
	<strong>
	更新に成功しました
	</strong>
	</div>
	</c:when>
	<c:when test="${!result}">
	<div id="failure">
	<strong>
	更新に失敗しました。学生一覧を確認して、その学生IDが存在するかチェックしてください。
	</strong>
	<a href="student-list">学生一覧</a>
	</div>
	</c:when>
</c:choose>


<%@include file="../common/footer.jsp" %>