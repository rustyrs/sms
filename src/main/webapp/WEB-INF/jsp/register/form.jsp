<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>

<h2>学生追加</h2>

<p>追加する学生の情報を入力してください。</p>

<form action="register" method="post">
	学生番号: <br><input type="number" name="id" class="input" required><br>
	学生名: <br><input type="text" name="name" class="input" required><br>
	コース番号: 
	<select name="course" required>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select><br>
	<br>
	<input type="submit" value="送信" class="button"><br>

</form>

<%@include file="../common/footer.jsp" %>