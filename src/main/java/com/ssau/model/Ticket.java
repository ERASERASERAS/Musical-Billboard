package com.ssau.model;

public class Ticket {
    private int id, concertId, cost, amount;
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getConcertId() {
        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Ticket(int id, int concertId, int cost, String category, int amount) {
        this.id = id;
        this.concertId = concertId;
        this.cost = cost;
        this.category = category;
        this.amount = amount;
    }


    public int getAmount() {
        return  amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

//    public String toString() {
//        return "";
//    }
}
