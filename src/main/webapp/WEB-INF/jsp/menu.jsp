<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="/css/menu.css" />
</jsp:include>

<h2>メニュー</h2>

<ul id="function-list">
	<li class="function">
        <a href="student-list">学生一覧</a>
        <p>学生の一覧を表示します。特に操作はできません。</p>
	</li>
	
	<li class="function">
        <a href="search">学生検索</a>
        <p>学生を名前で検索できます。</p>
	</li>
	
	<li class="function">
        <a href="register">学生追加</a>
        <p>詳細を入力することで学生を追加できます。</p>
	</li>
	
	<li class="function">
        <a href="delete">学生削除</a>
        <p>学生をIDで指定し、削除します。</p>
	</li>
	
	<li class="function">
        <a href="update">学生更新</a>
        <p>IDで指定した学生を、更新後の詳細を入力することで更新します。</p>
	</li>
</ul>

</body>
</html>