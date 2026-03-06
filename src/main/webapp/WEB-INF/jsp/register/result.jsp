<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h2>学生追加</h2>

登録を試みた学生番号:  <strong>${registNumber}</strong>
<br><br>
<c:if test="${!empty result}">
	<c:if test="${result}">登録に成功しました</c:if>
	<c:if test="${!result}">登録が失敗しました</c:if>
</c:if>
<c:if test="${isExistsRegister}">既に存在する学生番号です。重複はできません。</c:if>

<br><br>

<a href="register">再度追加する</a>

<%@include file="../common/footer.jsp" %>