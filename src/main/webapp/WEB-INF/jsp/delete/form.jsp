<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>

<jsp:include page="header.jsp">
    <jsp:param name="cssPath" value="/css/student-list.css" />
</jsp:include>

<h2>学生削除</h2>

<form action="delete" method="post">
	削除する生徒のID:
	<input type="text" name="id">
	
	<input type="submit">
</form>


<%@include file="../common/footer.jsp" %>