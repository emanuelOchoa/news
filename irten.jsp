<%
// bezeroak bidalitako kookie-ak berreskuratu
Cookie[] kookieak = request.getCookies();

// erabiltzailea izeneko kookie-a bilatu
if (kookieak != null) {
    for (int i = 0; i < kookieak.length; i++) {
        Cookie kookiea = kookieak[i];
        // aurkitzen bada eta bere balioa admin bada, orduan, kookie-a ezabatu eta hasierako orrira itzuli
        if (kookiea.getName().equals("erabiltzailea") && kookiea.getValue().equals("admin")) {
            kookiea.setMaxAge(0);
            response.addCookie(kookiea);
            response.sendRedirect("index.jsp");
            break;
        }
    }
}
%>
