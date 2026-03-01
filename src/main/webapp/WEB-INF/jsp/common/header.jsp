<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students Management System</title>
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
<header>
<h3 id="mode">管理者モード</h3>
<nav>
<a href="menu" class="headerLink">メニュー</a>
<a href="list" class="headerLink">学生一覧</a>
<a href="search" class="headerLink">学生検索</a>
<a href="register" class="headerLink">学生追加</a>
<a href="delete" class="headerLink">学生削除</a>
<a href="update" class="headerLink">学生更新</a>
</nav>
</header>