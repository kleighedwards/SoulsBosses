<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Souls Bosses</title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>

</head>
<body>
	<div class="bossInfo">
		<p>Name: ${selectedBoss.name}</p>
		<p>Location: ${selectedBoss.location}</p>
		<p>Summons: ${selectedBoss.summons}</p>
		<p>Transposed Weapons: ${selectedBoss.weapon}</p>
		<p>Weaknesses: ${selectedBoss.weaknesses}</p>
		<p>Optional: ${selectedBoss.optional}</p>
	</div>
	
	<img class="bossImage" src="BossImages/${selectedBoss.number}.jpg" alt="Your Boss Goes Here"/>
	
	<div class="bossSelect">
		<form action="DropDown.do" method="GET">
			<select name="menu">
				<c:forEach var="boss" items="${bossList}">
				<option value="${boss.name}">${boss.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Feeble Cursed One" />
		</form>
	</div>
	
</body>
</html>