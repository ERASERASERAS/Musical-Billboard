package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.model.Concert;
import com.ssau.model.ConcertDescription;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpCookie;

public class ConcertServlet extends HttpServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Concert concert = DAOFactory.getINSTANCE().getConcertDAO().getById(id);
        ConcertDescription concertDescription = new ConcertDescription();
        concertDescription.setConcertDate(concert.getConcertDate());
        concertDescription.setConcertId(id);
        concertDescription.setAddress(DAOFactory.getINSTANCE().getConcertHallDAO().getById(concert.getConcertHallId()).getAddress());
        concertDescription.setAgeConstraint(concert.getAgeConstraint());
        concertDescription.setArtistName(DAOFactory.getINSTANCE().getArtistDAO().getById(concert.getArtistId()).getName());
        concertDescription.setConcertHallName(DAOFactory.getINSTANCE().getConcertHallDAO().getById(concert.getConcertHallId()).getName());
        concertDescription.setDescription(concert.getDescriprion());
        concertDescription.setPromoGroupName(DAOFactory.getINSTANCE().getPromotionGroupDAO().getById(concert.getPromotionGroupId()).getName());
        concertDescription.setTickets(DAOFactory.getINSTANCE().getTicketDAO().getTicketsByConcert(id));
        req.getSession().setAttribute("concert_description", concertDescription);
        req.getRequestDispatcher("concert.jsp").forward(req,resp);

    }

}
