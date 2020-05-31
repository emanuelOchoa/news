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
		<h2>Erabiltzaile-Kontua aldatu</h2>

		<%

		ErabiltzaileKontua erabiltzaileKontua = (ErabiltzaileKontua)request.getAttribute("erabiltzaileKontua");
		String mezua = (String)request.getAttribute("mezua");

		%>

		<p><%= mezua %></p>
		<form action="" method="post">
			<%-- <p style="display:none"> --%>
			<p>
			<label for="webgunea">ID</label>
			<br/>
			<input type="text" id="id" name="id" value="<%= erabiltzaileKontua.getId() %>" readonly required disabled>
			</p>
			<p>
			<label for="webgunea">Webgunea</label>
			<br/>
			<input type="text" id="" name="webgunea" size="50" maxlength="200" value="<%= erabiltzaileKontua.getGunea() %>" required>
			</p>
			<p>
			<label for="erabiltzailea">Erabiltzailea</label>
			<br/>
			<textarea id="erabiltzailea" name="erabiltzailea" required><%= erabiltzaileKontua.getErabiltzaileIzena() %></textarea>
			</p>
			<p>
			<label for="pasahitza">Pasahitza</label>
			<br/>
			<textarea id="pasahitza" name="pasahitza" required><%= erabiltzaileKontua.getPasahitza() %></textarea>
			</p>
			<p>
			<input type="submit" name="aldatu" value="Aldatu">
			</p>
		</form>

		</body>
</html>
