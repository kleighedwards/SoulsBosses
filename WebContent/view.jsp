<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Souls Bosses</title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
	
</head>
<body>
	<p>${firstBoss}</p>
		
	<form action="DropDown.do" method="GET">
		<select name="menu">
			<c:forEach var="boss" items="${bossList}">
			<option value="${boss.name}">${boss.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Feeble Cursed One" />
	</form>
	
</body>
</html>