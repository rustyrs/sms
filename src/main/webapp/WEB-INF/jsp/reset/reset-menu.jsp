<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<jsp:include page="/WEB-INF/jsp/common/header.jsp">
    <jsp:param name="cssPath" value="/css/reset.css" />
</jsp:include>

<h2>データベース選択</h2>

<div id="database-list">
	<label id="manager" class="database" for="reset-manager">
        <img src="${pageContext.request.contextPath}/img/teacher.svg">
        <strong>教員DB</strong>
	</label>
	<label id="student" class="database" for="reset-student">
        <img src="${pageContext.request.contextPath}/img/student.svg">
        <strong>学生DB</strong>
	</label>
	<label id="log" class="database" for="reset-log">
        <img src="${pageContext.request.contextPath}/img/log.svg">
        <strong>ログDB</strong>
	</label>
</div>

<form action="reset" method="get">
	<input type="checkbox" name="reset-database" value="manager" id="reset-manager" onchange="choose()">
	<input type="checkbox" name="reset-database" value="student" id="reset-student" onchange="choose()">
	<input type="checkbox" name="reset-database" value="log" id="reset-log" onchange="choose()">
	
	<div id="choose-box"></div>
	
	が削除されます
	<input type="submit" value="削除">
</form>

<script>
function choose() {

	const parent = document.getElementById('choose-box');
	parent.innerHTML = ''; 
	
	let resetManager = document.getElementById('reset-manager').checked;
	let resetStudent = document.getElementById('reset-student').checked;
	let resetLog = document.getElementById('reset-log').checked;

	let chooseBox = document.getElementById('choose-box');

	let array = [];
	
	if (resetManager) {
		array.push('教員DB');
	} 
	if (resetStudent) {
		array.push('学生DB');
	} 
	if (resetLog) {
		array.push('ログDB');
	} 

	const uniqued = Array.from(new Set(array));

	console.log(uniqued);
	
	for (const c of uniqued) {
		let n = document.createElement('p');
		n.textContent = c;
		chooseBox.appendChild(n);
	}
}
</script>

</body>
</html>