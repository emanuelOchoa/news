<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.leartik.iberriozabal.erabiltzaile_kontuak.ErabiltzaileKontua" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Erabiltzaile-Kontuak</title>
	</head>
	<body>
		<p><a href="..">Hasiera/Inicio</a> &gt;</p>
		<h2>Erabiltzaile-Kontua ezabatu</h2>

		<%

		ErabiltzaileKontua erabiltzaileKontua = (ErabiltzaileKontua)request.getAttribute("erabiltzaileKontua");
		String mezua = (String)request.getAttribute("mezua");

		%>

		<p><%= mezua %></p>
		<table cellspacing="5" cellpadding="5" border="1">
			<tr>
				<td align="right">Webgunea:</td>
				<td><%= erabiltzaileKontua.getGunea() %></td>
			</tr>
			<tr>
				<td align="right">Erabiltzailea:</td>
				<td><%= erabiltzaileKontua.getErabiltzaileIzena() %></td>
			</tr>
			<tr>
				<td align="right">Pasahitza:</td>
				<td><%= erabiltzaileKontua.getPasahitza() %></td>
			</tr>
		</table>

		</body>
</html>
