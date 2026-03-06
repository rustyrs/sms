<%@page contentType="text/html; charset=UTF-8" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="/css/update.css" />
</jsp:include>

<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h2>学生更新</h2>
<c:if test="${!empty isExists}">
<c:if test="${!isExists}"><strong id="exists">存在しない生徒番号です</strong></c:if><br><br>
</c:if>
<form action="update-save-target" method="get">
	更新する生徒の生徒番号を入力してください。<br>
	<input type="number" name="target" class="input" required><br><br>
	<input type="submit" value="送信" class="button">
</form>

<%@include file="../common/footer.jsp" %>