package com.ssau.dao;

import com.ssau.model.Ticket;

import java.util.List;

public interface TicketDAO {
    Ticket getById(int id);
    List<Ticket> getTicketsByConcert(int concertId);
    List<String> getAllTicketsCategories(int concertId);
    int updateAmount(int ticketId, int newAmount);
    int update(int ticketId, int concertId, String category, int cost, int amount);
    int add(int concertId, String category, int cost, int amount);
    List<Ticket> getAll();
    int delete(int id);
    int deleteByConcertId(int concertId);

}
