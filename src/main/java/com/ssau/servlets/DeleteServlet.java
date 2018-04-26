package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.model.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entity = req.getParameter("entity");
        if(entity.equals("concert")) {
            deleteConcert(req);
            resp.sendRedirect("/");
        }
    }

    private  void deleteConcert(HttpServletRequest request) {
        int concertId = Integer.parseInt(request.getParameter("id"));
        List<Ticket> tickets = DAOFactory.getINSTANCE().getTicketDAO().getTicketsByConcert(concertId);
        for(Ticket ticket : tickets) {
            DAOFactory.getINSTANCE().getPurchaseDAO().deleteByTicketId(ticket.getId());
        }
        DAOFactory.getINSTANCE().getTicketDAO().deleteByConcertId(concertId);
        DAOFactory.getINSTANCE().getConcertDAO().delete(concertId);;
    }
}
