package com.ssau.model;

import java.util.Date;

public class Concert {
    private int id,artistId, concertHallId, promotionGroupId, ageConstraint;
    private Date concertDate;
    private String descriprion;

    public Concert(int id, int artistId, int concertHallId, int promotionGroupId, Date concertDate, int ageConstraint) {
        this.id = id;
        this.artistId = artistId;
        this.concertHallId = concertHallId;
        this.promotionGroupId = promotionGroupId;
        this.concertDate = concertDate;
        this.ageConstraint = ageConstraint;
    }

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
