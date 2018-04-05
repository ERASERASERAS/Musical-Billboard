package model;

public class Ticket {
    private int id, artistId, concertId, cost;
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
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

    public Ticket(int id, int artistId, int concertId, int cost, String category) {
        this.id = id;
        this.artistId = artistId;
        this.concertId = concertId;
        this.cost = cost;
        this.category = category;
    }


    public String toString() {
        return "";
    }
}
