<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Erabiltzaile-kontuak</title>
	</head>
	<body>
		<h1>Erabiltzaile-kontuak</h1>

		<%

				String mezua = (String)request.getAttribute("mezua");

		%>

		<p><%= mezua %></p>
		<form action="." method="post">
		<p>
		<label for="erabiltzailea">erabiltzailea</label>
		<input type="text" id="erabiltzailea" name="erabiltzailea" />
		</p>
		<p>
		<label for="pasahitza">pasahitza</label>
		<input type="password" id="pasahitza" name="pasahitza" />
		</p>
		<p>
		<input type="submit" name="sartu" value="Sartu" />
		</p>

	</body>
</html>
