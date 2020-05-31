package com.leartik.iberriozabal.erabiltzaile_kontuak;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import com.leartik.iberriozabal.erabiltzaile_kontuak.*;

public class ErabiltzaileKontuakErakutsiServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("id") != null){

            ErabiltzaileKontua erabiltzaileKontua = ErabiltzaileKontuaDB.selectErabiltzaileKontua(Integer.parseInt(request.getParameter("id")));

            request.setAttribute("erabiltzaileKontua", erabiltzaileKontua);

            ServletContext sc = getServletContext();

            RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontua_erakutsi.jsp");
            rd.forward(request, response);

        }else{

            ArrayList<ErabiltzaileKontua> erabiltzaileKontuak = ErabiltzaileKontuaDB.selectErabiltzaileKontuak();

            request.setAttribute("erabiltzaileKontuak", erabiltzaileKontuak);

            ServletContext sc = getServletContext();

            RequestDispatcher rd = sc.getRequestDispatcher("/erabiltzaile-kontuak_erakutsi.jsp");
            rd.forward(request, response);

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
