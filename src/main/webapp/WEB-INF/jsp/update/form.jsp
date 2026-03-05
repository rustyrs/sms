<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="/css/update.css" />
</jsp:include>


<form action="update-input" method="post" id="update-form">
	<div id="before" class="update-card">
		<h3>更新前</h3>
		<strong>生徒番号</strong><br>
		${targetNumber}<br>
		<strong>名前</strong><br>
		${targetName}<br>
		<strong>コース番号</strong><br>
		${targetCourse}
	</div>

	<div id="after"  class="update-card">
		<h3>更新後</h3>
		<strong>生徒番号</strong><br>
		<input type="text" value="${targetNumber}" name="number" class="input" disabled><br>
		<strong>名前</strong><br>
		<input type="text" name="name" class="input" required><br>
		<strong>コース番号</strong><br>
		<input type="text" name="course" class="input" required><br>
		
		<input type="submit" value="送信" class="button">
	</div>
</form>

<%@include file="../common/footer.jsp" %>