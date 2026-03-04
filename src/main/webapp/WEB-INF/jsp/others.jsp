<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="/css/others.css" />
</jsp:include>

<h2>限定操作</h2>

<div id="middle" class="role">
	<h3>主任以上の権限が必要です</h3>
	
	<hr>
	
	<div class="card">
		<a href="log-list">ログ</a>
		<p>SMSの操作履歴を確認できます。</p>
	</div>
	
	<div class="card">
		<a href="#">Coming soon</a>
		<p>Coming soon</p>
	</div>
</div>

<div id="high" class="role">
	<h3>副校長・教頭以上の権限が必要です</h3>
	
	<hr>
	
	<div class="card">
		<a href="stdent-details">学生の個人情報</a>
		<p>学生の詳細な個人情報を閲覧できます。</p>
	</div>
	
	<div class="card">
		<a href="#">Coming soon</a>
		<p>Coming soon</p>
	</div>
</div>

<div id="supreme" class="role">
	<h3>校長以上の権限が必要です</h3>
	
	<hr>
	
	<div class="card">
		<a href="logs">権限管理</a>
		<p>教員の権限を管理できます。</p>
	</div>
	
	<div class="card">
		<a href="#">Coming soon</a>
		<p>Coming soon</p>
	</div>
</div>



</body>
</html>