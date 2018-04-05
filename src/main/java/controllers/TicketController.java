package controllers;

import dao.DAOFactory;
import model.Ticket;

import java.util.List;

public class TicketController {

    public List<Ticket> getTicketsByConcert(int concertId) {
        return DAOFactory.getINSTANCE().getTicketDAO().getTicketsByConcert(concertId);
    }

    public List<Ticket>
}
