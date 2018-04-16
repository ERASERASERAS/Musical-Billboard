package com.ssau.controllers;

import com.ssau.dao.DAOFactory;
import com.ssau.model.Ticket;

import java.util.List;

public class TicketController {

    public List<Ticket> getTicketsByConcert(int concertId) {
        return DAOFactory.getINSTANCE().getTicketDAO().getTicketsByConcert(concertId);
    }
    //public List<Ticket>
}
