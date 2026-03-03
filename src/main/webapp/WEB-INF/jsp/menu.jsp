<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students Management System</title>
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
<link rel="stylesheet" href="<c:url value='/css/menu.css' />">
</head>
<body>
<header>
<h3 id="mode"><c:if test="${!empty name}">${name}</c:if></h3>
</header>

<h2>メニュー</h2>

<ul id="function-list">
	<li class="function">
        <a href="list">学生一覧</a>
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