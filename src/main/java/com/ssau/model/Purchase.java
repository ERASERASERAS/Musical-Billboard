package com.ssau.model;

public class Purchase {
    int id, userId,ticketId, amount;

    public Purchase() {}

    public Purchase(int id, int userId, int ticketId, int amount) {
        this.id = id;
        this.userId = userId;
        this.ticketId = ticketId;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
