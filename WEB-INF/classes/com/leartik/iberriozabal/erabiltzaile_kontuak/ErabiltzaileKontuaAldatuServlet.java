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

public class ErabiltzaileKontuaAldatuServlet extends HttpServlet
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
            if (request.getParameter("aldatu") != null)
            {
                int id = Integer.parseInt(request.getParameter("id"));
                String gunea = request.getParameter("webgunea");
                String erabiltzailea = request.getParameter("erabiltzailea");
                String pasahitza = request.getParameter("pasahitza");

                ErabiltzaileKontua erabiltzaileKontua = new ErabiltzaileKontua(id, gunea, erabiltzailea, pasahitza);

                if (gunea.length() > 0 && erabiltzailea.length() > 0 && pasahitza.length() > 0)
                {
                    if (ErabiltzaileKontuaDB.updateErabiltzaileKontua(erabiltzaileKontua) > 0)
                    {
                        request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                        request.setAttribute("mezua", "Erabiltzaile kontua aldatu da");
                        ServletContext sc = getServletContext();
                        RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontua_aldatu/erabiltzaile-kontua_aldatu_da.jsp");
                        rd.forward(request, response);
                    }
                    else
                    {
                        request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                        request.setAttribute("mezua", "Erabiltzaile kontua ez da aldatu");
                        ServletContext sc = getServletContext();
                        RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontua_aldatu/erabiltzaile-kontua_ez_da_aldatu.jsp");
                        rd.forward(request, response);
                    }
                }
                else
                {
                    request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                    request.setAttribute("mezua", "Eremu guztiak bete behar dira");
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontua_aldatu/erabiltzaile-kontua_aldatu.jsp");
                    rd.forward(request, response);
                }
            }
            else
            {
                int id = Integer.parseInt(request.getParameter("id"));
                ErabiltzaileKontua erabiltzaileKontua = ErabiltzaileKontuaDB.selectErabiltzaileKontua(id);
                request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);
                request.setAttribute("mezua", "");
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontua_aldatu/erabiltzaile-kontua_aldatu.jsp");
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
