package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.model.ConcertHall;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConcertHallServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        ConcertHall concertHall =  DAOFactory.getINSTANCE().getConcertHallDAO().getByName(name);
        req.getSession().setAttribute("concert_hall", concertHall);
        req.getRequestDispatcher("concerthall.jsp").forward(req,resp);
    }
}
