<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="/css/others.css" />
</jsp:include>

<h2>限定操作</h2>

<div id="functions">
<div id="middle" class="role">
	<h3>主任以上の権限が必要です</h3>
	
	<hr>
	
	<div class="card">
		<a class="function" href="log-list">ログ</a>
		<p>SMSの操作履歴を確認できます。</p>
	</div>
	
	<div class="card">
		<a class="function" href="#">コース一覧</a>
		<p>コースの一覧を見ることができます。</p>
	</div>
</div>

<div id="high" class="role">
	<h3>副校長・教頭以上の権限が必要です</h3>
	
	<hr>
	
	<div class="card">
		<a class="function" href="stdent-details">教員管理</a>
		<p>教員に対する操作ができます。</p>
	</div>
	
	<div class="card">
		<a class="function" href="#">コース管理</a>
		<p>コースに対する操作ができます。</p>
	</div>
</div>

<div id="supreme" class="role">
	<h3>校長以上の権限が必要です</h3>
	
	<hr>
	
	<div class="card">
		<a class="function" href="logs">学生データリセット</a>
		<p>学生のデータベースを削除し、作り直します。</p>
	</div>
	
	<div class="card">
		<a class="function" href="#">教員データリセット</a>
		<p>教員のデータベースを削除し、作り直します。これを行うと学生のデータベースもリセットされます。</p>
	</div>
	
	<div class="card">
		<a class="function" href="#">ログデータリセット</a>
		<p>ログのデータベースを削除し、作り直します。</p>
	</div>
</div>
</div>



</body>
</html>