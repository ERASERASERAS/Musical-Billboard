package com.ssau.servlets;

import com.ssau.dao.ConcertDAO;
import com.ssau.dao.DAOFactory;
import com.ssau.dao.TicketDAO;
import com.ssau.model.Purchase;
import com.ssau.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Purchase> purchases = DAOFactory.getINSTANCE().getPurchaseDAO().getPurchasesForUser(user.getId());
        TicketDAO ticketDAO = DAOFactory.getINSTANCE().getTicketDAO();
        ConcertDAO concertDAO = DAOFactory.getINSTANCE().getConcertDAO();
        req.getSession().setAttribute("purchases", purchases);
        req.getSession().setAttribute("ticket", ticketDAO);
        req.getSession().setAttribute("concert", concertDAO);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }


}
