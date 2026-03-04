<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h1>ID: ${id}</h1>

<dl>
  <dt>名前</dt>
  <dd>${name}</dd>
</dl>

<%@include file="../common/footer.jsp" %>