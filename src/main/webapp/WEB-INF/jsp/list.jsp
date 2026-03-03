<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h2>学生一覧</h2>

<table border="1">
	<thead>
		<tr>
			<th>学生番号</th>
			<th>学生名</th>
			<th>コース番号</th>			
		</tr> 
	</thead>
	
	<c:forEach var="s" items="${students}">
		<tbody>
			<tr>
				<th>${s.id}</th>
				<td>${s.name}</td>
				<td>${s.course}</td>
			</tr>
		</tbody>
	</c:forEach>
</table>


<%@include file="common/footer.jsp" %>