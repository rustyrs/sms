<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h1>学生番号: ${number}</h1>

<dl>
  <dt>名前</dt>
  <dd>${name}</dd>
  <dt>コース番号</dt>
  <dd>${course}</dd>
</dl>

<%@include file="../common/footer.jsp" %>