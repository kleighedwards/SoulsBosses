<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Souls Bosses</title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
	
</head>
<body>
	<div class="bossInfo">
		<p>Name: ${firstBoss.name}</p>
		<p>Location: ${firstBoss.location}</p>
		<p>Summons: ${firstBoss.summons}</p>
		<p>Transposed Weapons: ${firstBoss.weapon}</p>
		<p>Weaknesses: ${firstBoss.weaknesses}</p>
		<p>Optional: ${firstBoss.optional}</p>
	</div>
	
	<img class="bossImage" src="BossImages/0.jpg" alt="Iudex Gundyr"/>
	
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

</body>
</html>