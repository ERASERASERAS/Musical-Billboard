package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.model.ConcertHall;
import com.ssau.model.PromotionGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entity = req.getParameter("entity");
        if(entity.equals("concert")) {
            addConcert(req);
        } else if(entity.equals("promo_group")) {
            addPromotionGroup(req);
        } else if(entity.equals("concert_hall")) {
            addConcertHall(req);
        } else if(entity.equals("ticket")) {
            addTicket(req);
        }
        resp.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entity = req.getParameter("entity");
        if(entity.equals("concert")) {
            List<ConcertHall> concertHalls = DAOFactory.getINSTANCE().getConcertHallDAO().getAll();
            List<PromotionGroup> promotionGroups = DAOFactory.getINSTANCE().getPromotionGroupDAO().getAll();
            req.getSession().setAttribute("promo_groups", promotionGroups);
            req.getSession().setAttribute("concert_halls", concertHalls);
            req.getRequestDispatcher("add_concert.jsp").forward(req, resp);
        } else if (entity.equals("promo_group")) {
            req.getRequestDispatcher("add_promo_group.jsp").forward(req,resp);
        } else if (entity.equals("concert_hall")) {
            req.getRequestDispatcher("add_concert_hall.jsp").forward(req, resp);
        } else if(entity.equals("ticket")) {
            req.getSession().setAttribute("concert", DAOFactory.getINSTANCE().getConcertDAO().getById(Integer.parseInt(req.getParameter("concertId"))));
            req.getRequestDispatcher("add_ticket.jsp").forward(req, resp);
        }
    }

    private void addConcert(HttpServletRequest request) {

    }

    private void addTicket(HttpServletRequest request) {
       int concertId = Integer.parseInt(request.getParameter("concertId"));
       String category = request.getParameter("category");
       int cost = Integer.parseInt(request.getParameter("cost"));
       int amount = Integer.parseInt(request.getParameter("amount"));
       DAOFactory.getINSTANCE().getTicketDAO().add(concertId, category, cost, amount);
    }

    private void addConcertHall(HttpServletRequest request) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        DAOFactory.getINSTANCE().getConcertHallDAO().add(name, address, telephone, email);
    }

    private void  addPromotionGroup(HttpServletRequest request) {
        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        DAOFactory.getINSTANCE().getPromotionGroupDAO().add(name, telephone, email);
    }


}
