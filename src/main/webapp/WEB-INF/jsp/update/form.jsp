<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>

<h2>学生更新</h2>

<form action="update" method="post">
	更新する生徒のID:
	<input type="text" name="target" class="input"><br><br>

	更新後の<br>
	学生番号:<br>
	 <input type="text" name="id" class="input"><br>
	学生名:<br>
	 <input type="text" name="name" class="input"><br>
	コース番号: 
	<select name="course">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select><br><br>
	
	<input type="submit" value="送信" class="button">
</form>

<%@include file="../common/footer.jsp" %>