<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../../common/header.jsp" %>

<form action="update" method="post">
	更新する生徒のID:
	<input type="text" name="target"><br><br>

	更新後の<br>
	学生番号: <input type="number" name="id"><br>
	学生名: <input type="text" name="name"><br>
	コース番号: 
	<select name="course">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select><br>
	
	<input type="submit" value="送信"><br>
	
	<a href="menu">メニューへ</a>
</form>

<%@include file="../../common/footer.jsp" %>