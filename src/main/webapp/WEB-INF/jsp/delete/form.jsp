<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h2>学生削除</h2>

<c:if test="${!empty deleteExists}">
<c:if test="${!deleteExists}">
<strong id="exists">その学生IDは存在しません</strong>
</c:if>
</c:if>

<form action="delete" method="post">
	削除する生徒の学生ID:<br>
	<input type="text" name="id" class="input" required>
	<br><br>
	<input type="submit" class="button"><br>
</form>

<%@include file="../common/footer.jsp" %>