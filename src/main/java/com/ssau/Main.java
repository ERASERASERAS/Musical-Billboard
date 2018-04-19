package com.ssau;



import com.ssau.dao.DAOFactory;
import com.ssau.dao.JDBCDAOFactory;
import com.ssau.model.Concert;
import com.ssau.servlets.LoginServlet;

import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String [] args) {
//        JDBCDAOFactory jdbcdaoFactory = (JDBCDAOFactory) DAOFactory.getINSTANCE();
//        System.out.println(jdbcdaoFactory.getArtistDAO().getById(1).getName());
 //      System.out.println(DAOFactory.getINSTANCE().getConcertDAO().getById(1).getConcertDate());
//        List<Concert> c = jdbcdaoFactory.getConcertDAO().getConcertsBetweenDates(Date.valueOf("2018-01-01"), Date.valueOf("2018-10-10"));
//        System.out.println("fdfdf");
        //System.out.println(new LoginServlet().checkLogin("TestUser", "TestPass"));
       //System.out.println(DAOFactory.getINSTANCE().getUserDAO().getUserById(2).getLogin());
    }
}
