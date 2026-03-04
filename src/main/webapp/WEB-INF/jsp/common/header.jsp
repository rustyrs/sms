<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<c:set var="currentPath" value="${pageContext.request.servletPath}" />

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
<h3 id="name">
    <c:if test="${!empty name}">${name}</c:if>
    <c:if test="${empty name}">SMS</c:if>    
</h3>
<nav id="header-nav">
<a href="menu" class="header-link" ${currentPath == '/WEB-INF/jsp/menu.jsp' ? 'id="current"' : ''}>メニュー</a>
<a href="list" class="header-link" ${currentPath == '/WEB-INF/jsp/list.jsp' ? 'id="current"' : ''}>学生一覧</a>
<a href="search" class="header-link" ${currentPath == '/WEB-INF/jsp/search/form.jsp' ? 'id="current"' : ''} ${currentPath == '/WEB-INF/jsp/search/result.jsp' ? 'id="current"' : ''}>学生検索</a>
<a href="register" class="header-link" ${currentPath == '/WEB-INF/jsp/register/form.jsp' ? 'id="current"' : ''} ${currentPath == '/WEB-INF/jsp/register/result.jsp' ? 'id="current"' : ''}>学生追加</a>
<a href="delete" class="header-link" ${currentPath == '/WEB-INF/jsp/delete/form.jsp' ? 'id="current"' : ''} ${currentPath == '/WEB-INF/jsp/delete/result.jsp' ? 'id="current"' : ''}>学生削除</a>
<a href="update" class="header-link" ${currentPath == '/WEB-INF/jsp/update/form.jsp' ? 'id="current"' : ''} ${currentPath == '/WEB-INF/jsp/update/result.jsp' ? 'id="current"' : ''}>学生更新</a>
<a href="others" class="header-link" ${currentPath == '/WEB-INF/jsp/others.jsp' ? 'id="current"' : ''}>その他</a>
</nav>
</header>

<div id="watch">
${time}<br>
${date}
</div>