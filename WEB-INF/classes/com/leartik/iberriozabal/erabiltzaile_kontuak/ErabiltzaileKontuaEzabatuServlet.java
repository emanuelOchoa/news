package com.leartik.iberriozabal.erabiltzaile_kontuak;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.leartik.iberriozabal.erabiltzaile_kontuak.*;

public class ErabiltzaileKontuaEzabatuServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        boolean admin = false;

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

        if (admin == true)
        {

            if (request.getParameter("bai") != null && request.getParameter("id") != null) {

                int id = Integer.parseInt(request.getParameter("id"));

                ErabiltzaileKontua erabiltzaileKontua = ErabiltzaileKontuaDB.selectErabiltzaileKontua(id);

                int emaitza = ErabiltzaileKontuaDB.deleteErabiltzaileKontua(id);

                if (emaitza > 0)
                {
                    request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                    request.setAttribute("mezua", "Erabiltzaile kontua ezabatu da");
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontua_ezabatu/erabiltzaile-kontua_ezabatu_da.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                    request.setAttribute("mezua", "Erabiltzaile kontua ez da ezabatu");
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontua_ezabatu/erabiltzaile-kontua_ez_da_ezabatu.jsp");
                    rd.forward(request, response);
                }

            } else if (request.getParameter("ez") != null) {

                  int id = Integer.parseInt(request.getParameter("id"));

                  ErabiltzaileKontua erabiltzaileKontua = ErabiltzaileKontuaDB.selectErabiltzaileKontua(id);

                  request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                  request.setAttribute("mezua", "Erabiltzaile kontua ez da ezabatu");
                  ServletContext sc = getServletContext();
                  RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontua_ezabatu/erabiltzaile-kontua_ez_da_ezabatu.jsp");
                  rd.forward(request, response);

      			} else if (request.getParameter("id") != null) {

              int id = Integer.parseInt(request.getParameter("id"));

              ErabiltzaileKontua erabiltzaileKontua = ErabiltzaileKontuaDB.selectErabiltzaileKontua(id);

              request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
              ServletContext sc = getServletContext();
              RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontua_ezabatu/erabiltzaile-kontua_ezabatu.jsp");
              rd.forward(request, response);

            }

        }
        else
        {

            response.sendRedirect("..");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
