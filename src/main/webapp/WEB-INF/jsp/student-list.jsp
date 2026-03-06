<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="common/header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<h2>学生一覧</h2>

<br>

<form action="student-list" method="get">
	<input type="text" name="course-id">
	<input type="submit" value="コース番号で絞り込む">
</form>

<br>
<p>クリックで更新画面に飛びます</p>

<table border="1">
	<thead>
		<tr>
			<th>学生ID</th>
			<th>学生名</th>
			<th>コース番号</th>			
		</tr> 
	</thead>
	
	<c:forEach var="s" items="${students}">
		<tbody onclick="location.href='update-select?target='+${s.id}">
			<tr>
				<th>${s.id}</th>
				<td>${s.name}</td>
				<td>${s.course}</td>
			</tr>
		</tbody>
	</c:forEach>
</table>


<%@include file="common/footer.jsp" %>