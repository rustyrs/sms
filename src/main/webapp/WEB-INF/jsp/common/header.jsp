<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students Management System</title>
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
<link rel="stylesheet" href="<c:url value='/css/header.css' />">
<c:if test="${!empty param.cssPath}">
    <link rel="stylesheet" href="<c:url value='${param.cssPath}' />" />
</c:if>
</head>
<body>
<header>
<h3 id="name"><c:if test="${!empty name}">${name}</c:if></h3>
<nav id="header-nav">
<a href="menu" class="header-link">メニュー</a>
<a href="list" class="header-link">学生一覧</a>
<a href="search" class="header-link">学生検索</a>
<a href="register" class="header-link">学生追加</a>
<a href="delete" class="header-link">学生削除</a>
<a href="update" class="header-link">学生更新</a>
</nav>
</header>