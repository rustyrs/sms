<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="/css/log-list.css" />
</jsp:include>

<h2>ログ一覧</h2>

<div id="filter">
	<form action="log-list" method="get">
		<strong>実行者IDで絞り込む</strong>
		<input type="text" name="executor-id">
		<input type="submit" value="検索">
	</form>
	
	<form action="log-list" method="get">
		<strong>処理メソッドで絞り込む</strong>
		<select name="action-type">
			<option value="POST">POST</option>
			<option value="GET">GET</option>
			<option value="UPDATE">UPDATE</option>
			<option value="DELETE">DELETE</option>
		</select>
		<input type="submit" value="検索">
	</form>
	
	<form action="log-list" method="get">
		<strong>対象テーブルで絞り込む</strong>
		<select name="target-table">
			<option value="students">students</option>
			<option value="managers">managers</option>
			<option value="logs">logs</option>
		</select>
		<input type="submit" value="検索">
	</form>
</div>

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
	
	<c:forEach var="log" items="${logs}">
		<tbody>
			<tr>
				<th>${log.logId}</th>
				<th>${log.userId}</th>
				<th id="${log.actionType}">${log.actionType}</th>
				<th>${log.targetTable}</th>
				<th>${log.actionedAt}</th>
			</tr>
		</tbody>
	</c:forEach>
</table>

<%@include file="common/footer.jsp" %>