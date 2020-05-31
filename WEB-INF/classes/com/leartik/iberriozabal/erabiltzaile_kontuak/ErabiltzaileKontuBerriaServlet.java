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

public class ErabiltzaileKontuBerriaServlet extends HttpServlet
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
            if (request.getParameter("gorde") != null)
            {
                String gunea = request.getParameter("webgunea");
                String erabiltzailea = request.getParameter("erabiltzailea");
                String pasahitza = request.getParameter("pasahitza");

                ErabiltzaileKontua erabiltzaileKontua = new ErabiltzaileKontua(gunea, erabiltzailea, pasahitza);

                if (gunea.length() > 0 && erabiltzailea.length() > 0 && pasahitza.length() > 0)
                {
                    if (ErabiltzaileKontuaDB.insertErabiltzaileKontua(erabiltzaileKontua) > 0)
                    {
                        request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                        request.setAttribute("mezua", "Erabiltzaile kontua gorde da");
                        ServletContext sc = getServletContext();
                        RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontu_berria/erabiltzaile-kontua_gorde_da.jsp");
                        rd.forward(request, response);
                    }
                    else
                    {
                        request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                        request.setAttribute("mezua", "Erabiltzaile kontua ez da gorde");
                        ServletContext sc = getServletContext();
                        RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontu_berria/erabiltzaile-kontua_ez_da_gorde.jsp");
                        rd.forward(request, response);
                    }
                }
                else
                {
                    request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                    request.setAttribute("mezua", "Eremu guztiak bete behar dira");
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontu_berria/erabiltzaile-kontu_berria.jsp");
                    rd.forward(request, response);
                }
            }
            else
            {
                ErabiltzaileKontua erabiltzaileKontua = new ErabiltzaileKontua();
                request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                request.setAttribute("mezua", "");
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontu_berria/erabiltzaile-kontu_berria.jsp");
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
