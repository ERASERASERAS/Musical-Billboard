package dao;

public abstract class DAOFactory {
    private static DAOFactory INSTANCE = new JDBCDAOFactory();

     DAOFactory() {}

    public static DAOFactory getINSTANCE() {
        return INSTANCE;
    }



    public abstract ArtistDAO getArtistDAO();

    public abstract ConcertDAO getConcertDAO();

    public abstract ConcertHallDAO getConcertHallDAO();

    public abstract PromotionGroupDAO getPromotionGroupDAO();

    public abstract TicketDAO getTicketDAO();



    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
