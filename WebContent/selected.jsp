<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Souls Bosses</title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>

</head>
<body>
	<div class="bossInfo">
		<p>Name: ${oldBoss.name}</p>
		<p>Location: ${oldBoss.location}</p>
		<p>Summons: ${oldBoss.summons}</p>
		<p>Transposed Weapons: ${oldBoss.weapon}</p>
		<p>Weaknesses: ${oldBoss.weaknesses}</p>
		<p>Optional: ${oldBoss.optional}</p>
	</div>
	
	<img class="bossImage" src="BossImages/${oldBoss.number}.jpg" alt="Your Boss Goes Here"/>
	
	<div class="bossSelect">
		<form action="DropDown.do" method="GET">
			<select name="menu">
				<c:forEach var="boss" items="${bossList}">
				<option value="${boss.name}">${boss.name}</option>
				</c:forEach>
			</select>
			<input type="submit" name="button" value="Feeble Cursed One"/><br>
			<input type="submit" name="button" value="Previous"/>
			<input type="submit" name="button" value="Next"/>
		</form>
	</div>
	${oldBoss}
</body>
</html>