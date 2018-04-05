import dao.DAOFactory;
import dao.JDBCDAOFactory;
import dao.jdbc.JDBCArtistDAO;

public class Main {

    public static void main(String [] args) {
        JDBCDAOFactory jdbcdaoFactory = (JDBCDAOFactory) DAOFactory.getINSTANCE();
        System.out.println(new JDBCArtistDAO().getById(1).getName());
    }
}
