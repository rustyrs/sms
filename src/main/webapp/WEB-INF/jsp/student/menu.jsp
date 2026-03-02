<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students Management System</title>
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
<link rel="stylesheet" href="<c:url value='/css/manager/menu.css' />">
</head>
<body>
<header>
<h3 id="mode">学生モード</h3>

</header>

<h2>メニュー</h2>

<ul id="function-list">
	<li class="function">
        <a href="my-profile">プロフィール</a>
        <p>プロフィールを編集できます。</p>
	</li>
	
	<li class="function">
        <a href="profiles">みんなのプロフィール</a>
        <p>学生全員のプロフィールを見れます。</p>
	</li>
</ul>

</body>
</html>