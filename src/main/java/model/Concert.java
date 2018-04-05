package model;

import java.util.Date;

public class Concert {
    private int id,artistId, concertHallId, promotionGroupId;
    private Date concertDate;

    public Concert(int id, int artistId, int concertHallId, int promotionGroupId, Date concertDate) {
        this.id = id;
        this.artistId = artistId;
        this.concertHallId = concertHallId;
        this.promotionGroupId = promotionGroupId;
        this.concertDate = concertDate;
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


}
