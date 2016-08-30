<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Souls Bosses</title>
</head>
<body>
	<p>${firstBoss}</p>
		
	${bossList[1].name}
		
	<form action="DropDown.do" method="POST">
		<select name="menu">
			<c:forEach var="boss" items="${bossList}">
			<option value="${boss.name}">${boss.name}</option>
			</c:forEach>
		</select>
	</form>
	
</body>
</html>