package com.ssau.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ConcertDescription {
    int concertId, ageConstraint;
    String artistName,concertHallName,address, promoGroupName,description;
    List<Ticket> tickets = new LinkedList<Ticket>();
    Date concertDate;

    public Date getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(Date concertDate) {
        this.concertDate = concertDate;
    }

    public ConcertDescription(int concertId, String artistName, String concertHallName, String address, String promoGroupName, int ageConstraint, String description, List<Ticket> tickets, Date concertDate) {
        this.concertId = concertId;
        this.artistName = artistName;
        this.concertHallName = concertHallName;
        this.address = address;
        this.promoGroupName = promoGroupName;
        this.ageConstraint = ageConstraint;
        this.description = description;
        this.tickets = tickets;
        this.concertDate = concertDate;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getConcertHallName() {
        return concertHallName;
    }

    public void setConcertHallName(String concertHallName) {
        this.concertHallName = concertHallName;
    }

    public int getConcertId() {

        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPromoGroupName() {
        return promoGroupName;
    }

    public void setPromoGroupName(String promoGroupName) {
        this.promoGroupName = promoGroupName;
    }

    public int getAgeConstraint() {
        return ageConstraint;
    }

    public void setAgeConstraint(int ageConstraint) {
        this.ageConstraint = ageConstraint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ConcertDescription() {}
}
