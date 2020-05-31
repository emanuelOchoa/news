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
		// String mezua = (String)request.getAttribute("mezua");

		%>

		<p>Erabiltzaile-Kontua:</p>

		<table cellspacing="5" cellpadding="5" border="1">
			<tr>
				<td align="right">ID:</td>
				<td><%= erabiltzaileKontua.getId() %></td>
			</tr>
			<tr>
				<td align="right">Wegunea:</td>
				<td><%= erabiltzaileKontua.getGunea() %></td>
			</tr>
			<tr>
				<td align="right">Erabiltzailea:</td>
				<td><%= erabiltzaileKontua.getErabiltzaileIzena() %></td>
			</tr>
			<tr>
				<td align="right">PAsahitza:</td>
				<td><%= erabiltzaileKontua.getPasahitza() %></td>
			</tr>
		</table>

		<p>Ziur zaude?</p>

		<form action="" method="post">
			<p>
				<input type="submit" name="bai" value="Bai">
				<input type="submit" name="ez" value="Ez">
				<label for="id">ID</label>
				<input type="text" id="id" name="id" value="<%= request.getParameter("id") %>" disabled>
			</p>
		</form>

		</body>
</html>
