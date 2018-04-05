package dao;

import model.Ticket;

import java.util.List;

public interface TicketDAO {
    Ticket getById(int id);
    List<Ticket> getTicketsByConcert(int concertId);
    List<String> getAllTicketsCategories(int concertId);

}
