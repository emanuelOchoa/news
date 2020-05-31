package com.leartik.iberriozabal.erabiltzaile_kontuak;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import com.leartik.iberriozabal.erabiltzaile_kontuak.*;

public class ErabiltzaileKontuakAdminServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        boolean admin = false;

        if (request.getParameter("sartu") != null)
        {
            if (request.getParameter("erabiltzailea").equals("admin") && request.getParameter("pasahitza").equals("admin"))
            {
                admin = true;
                Cookie kookiea = new Cookie("erabiltzailea", "admin");
                kookiea.setMaxAge (60*60*24) ;
                response.addCookie(kookiea);
            }
        }
        else
        {
          Cookie[] cookies = request.getCookies();

          if (cookies != null)
          {
                for (int i = 0; i < cookies.length; i++)
                {
                    Cookie cookie = cookies[i];
                    if (cookie.getName().equals("erabiltzailea") && cookie.getValue().equals("admin"))
                    {
                        admin = true;
                        break;
                    }
                }
            }
        }

        if (admin == true)
        {
            ArrayList<ErabiltzaileKontua> erabiltzaileKontuak = ErabiltzaileKontuaDB.selectErabiltzaileKontuak();
            request.setAttribute("erabiltzaileKontuak", erabiltzaileKontuak);
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontuak_erakutsi.jsp");
            rd.forward(request, response);
        }
        else
        {

            String mezua;

            if (request.getParameter("sartu") != null)
            {
                mezua = "Datuak ez dira zuzenak";
            }
            else
            {
                mezua = "";
            }

            request.setAttribute("mezua", mezua);
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
