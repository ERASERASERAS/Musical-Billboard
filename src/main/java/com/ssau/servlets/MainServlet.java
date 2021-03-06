package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.model.Concert;
import com.ssau.model.PromotionGroup;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entity = req.getParameter("entity");
        if(entity == null || entity.equals("concert")) {
            List<Concert> f = DAOFactory.getINSTANCE().getConcertDAO().getAll();
            req.getSession().setAttribute("concerts", DAOFactory.getINSTANCE().getConcertDAO().getAll());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if (entity.equals("promo_group")) {
            List<PromotionGroup> promotionGroups = DAOFactory.getINSTANCE().getPromotionGroupDAO().getAll();
            req.getSession().setAttribute("promo_groups", promotionGroups);
            req.getRequestDispatcher("promo_groups").forward(req, resp);
        }
    }
}
