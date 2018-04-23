package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.model.PromotionGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PromoGroupServlet  extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        PromotionGroup promotionGroup = DAOFactory.getINSTANCE().getPromotionGroupDAO().getByName(name);
        req.getSession().setAttribute("promo_group", promotionGroup);
        req.getRequestDispatcher("promogroup.jsp").forward(req,resp);
    }
}
