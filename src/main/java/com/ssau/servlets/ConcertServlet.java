package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.dao.TicketDAO;
import com.ssau.model.Concert;
import com.ssau.model.ConcertDescription;
import com.ssau.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpCookie;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConcertServlet extends HttpServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cp = req.getContextPath();
        int amount = Integer.parseInt(req.getParameter("amount"));
        int ticketId = Integer.parseInt(req.getParameter("ticketId"));
        User user = (User) req.getSession().getAttribute("user");
        DAOFactory.getINSTANCE().getPurchaseDAO().addPurchase(DAOFactory.getINSTANCE().getPurchaseDAO().getAll().size() + 1,user.getId(), ticketId, amount);
        TicketDAO ticketDAO = DAOFactory.getINSTANCE().getTicketDAO();
        ticketDAO.updateAmount(ticketId, ticketDAO.getById(ticketId).getAmount() - amount);
        resp.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Concert concert = DAOFactory.getINSTANCE().getConcertDAO().getById(id);
        ConcertDescription concertDescription = new ConcertDescription();
        java.util.Date formatDate = null;
        try {
            formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(concert.getConcertDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        concertDescription.setConcertDate(concert.getConcertDate());
        concertDescription.setConcertId(id);
        concertDescription.setAddress(DAOFactory.getINSTANCE().getConcertHallDAO().getById(concert.getConcertHallId()).getAddress());
        concertDescription.setAgeConstraint(concert.getAgeConstraint());
        concertDescription.setArtistName(concert.getArtist());
        concertDescription.setConcertHallName(DAOFactory.getINSTANCE().getConcertHallDAO().getById(concert.getConcertHallId()).getName());
        concertDescription.setDescription(concert.getDescriprion());
        concertDescription.setPromoGroupName(DAOFactory.getINSTANCE().getPromotionGroupDAO().getById(concert.getPromotionGroupId()).getName());
        concertDescription.setTickets(DAOFactory.getINSTANCE().getTicketDAO().getTicketsByConcert(id));
        req.getSession().setAttribute("concert_description", concertDescription);
        req.getRequestDispatcher("concert.jsp").forward(req,resp);

    }

}
