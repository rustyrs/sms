<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="/css/log-list.css" />
</jsp:include>

<h2>ログ一覧</h2>

<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>実行者ID</th>
			<th>処理メソッド</th>			
			<th>対象テーブル</th>			
			<th>実行日時</th>			
		</tr> 
	</thead>
	
	<c:forEach var="s" items="${logs}">
		<tbody>
			<tr>
				<th>${logs.logId}</th>
				<th>${logs.userId}</th>
				<th>${logs.actionType}</th>
				<th>${logs.targetTable}</th>
				<th>${logs.actionedAt}</th>
			</tr>
		</tbody>
	</c:forEach>
</table>

<%@include file="common/footer.jsp" %>