<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.leartik.iberriozabal.erabiltzaile_kontuak.ErabiltzaileKontua" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Erabiltzaile-kontuak</title>
	</head>
	<body>
		<h1>Erabiltzaile-kontuak</h1>

		<%

		ArrayList<ErabiltzaileKontua> erabiltzaileKontuak = (ArrayList<ErabiltzaileKontua>)request.getAttribute("erabiltzaileKontuak");

		out.println("<dl>");

		for (int i=0 ; i < erabiltzaileKontuak.size() ; i++) { %>

					<dt>
						Webgunea: <%= erabiltzaileKontuak.get(i).getGunea() %>
						[<a href="erabiltzaile-kontua_aldatu/index.jsp?id=<%= erabiltzaileKontuak.get(i).getId() %>">aldatu</a>]
						[<a href="erabiltzaile-kontua_ezabatu/index.jsp?id=<%= erabiltzaileKontuak.get(i).getId() %>">ezabatu</a>]
					</dt>
					<dd>
						Erabiltzaile-izena: <%= erabiltzaileKontuak.get(i).getErabiltzaileIzena() %>
					</dd>
					<dd>
						Pasahitza: <%= erabiltzaileKontuak.get(i).getPasahitza() %>
					</dd>

		<% }

		out.println("</dl>");

		%>

		<form action="erabiltzaile-kontu_berria" method="post">
		<p><input type="submit" value="Erabiltzaile-kontu berria" /></p>
		</form>
		<p><a href="irten.jsp">Sesiotik irten</a></p>

	</body>
</html>
