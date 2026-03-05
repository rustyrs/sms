<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h2>教員一覧</h2>

<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>名前</th>		
		</tr> 
	</thead>
	
	<c:forEach var="m" items="${managers}">
		<tbody>
			<tr>
				<th>${m.id}</th>
				<td>${m.name}</td>
			</tr>
		</tbody>
	</c:forEach>
</table>


<%@include file="common/footer.jsp" %>