package com.ssau.model;

import java.util.Date;

public class Concert {
    private int id, concertHallId, promotionGroupId, ageConstraint;
    private Date concertDate;
    private String descriprion, artist;

    public Concert(int id, int concertHallId, int promotionGroupId, Date concertDate, String descriprion, int ageConstraint, String artist) {
        this.id = id;
        this.concertHallId = concertHallId;
        this.promotionGroupId = promotionGroupId;
        this.concertDate = concertDate;
        this.ageConstraint = ageConstraint;
        this.descriprion = descriprion;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getConcertHallId() {
        return concertHallId;
    }

    public void setConcertHallId(int concertHallId) {
        this.concertHallId = concertHallId;
    }

    public int getPromotionGroupId() {
        return promotionGroupId;
    }

    public void setPromotionGroupId(int promotionGroupId) {
        this.promotionGroupId = promotionGroupId;
    }

    public Date getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(Date concertDate) {
        this.concertDate = concertDate;
    }

    public int getAgeConstraint() {
        return ageConstraint;
    }

    public void setAgeConstraint(int ageConstraint) {
        this.ageConstraint = ageConstraint;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    @Override
    public String toString() {
        return "";
    }
}
