<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.jsp" %>

<h2>学生検索</h2>

<form action="search" method="post">
	
	お名前:<br><br>
	<input type="text" name="name" class="input">
	
	<br><br>
	
	あいまい検索を有効にする
	<div class="checkbox-wrapper-6">
  		<input class="tgl tgl-light" id="cb1-6" type="checkbox" name="fuzzy"/>
  		<label class="tgl-btn" for="cb1-6">
	</div>
	
	<br><br>
	
	<input type="submit" value="検索" class="button">
	
</form>

<%@include file="../common/footer.jsp" %>

