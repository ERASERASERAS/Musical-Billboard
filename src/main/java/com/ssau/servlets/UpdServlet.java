package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.model.ConcertHall;
import com.ssau.model.PromotionGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

public class UpdServlet extends HttpServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entity = req.getParameter("entity");
        if(entity.equals("concert")) {
            try {
                updateConcert(req);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entity = req.getParameter("entity");
        if(entity.equals("concert")) {
            List<ConcertHall> concertHalls = DAOFactory.getINSTANCE().getConcertHallDAO().getAll();
            List<PromotionGroup> promotionGroups = DAOFactory.getINSTANCE().getPromotionGroupDAO().getAll();
            req.getSession().setAttribute("promo_groups", promotionGroups);
            req.getSession().setAttribute("concert_halls", concertHalls);
            req.getRequestDispatcher("update_concert.jsp").forward(req, resp);
        } else if (entity.equals("promo_group")) {
            req.getRequestDispatcher("update_promo_group.jsp").forward(req,resp);
        } else if (entity.equals("concert_hall")) {
            req.getRequestDispatcher("update_concert_hall.jsp").forward(req, resp);
        }
    }

    private void updateConcert(HttpServletRequest request) throws ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String artist = request.getParameter("artist");
        String datee1 = request.getParameter("date").replaceFirst("T"," ");
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("date").replaceFirst("T"," "));
        //Date date = new Date(Date.parse(request.getParameter("date").replaceFirst("T", " ")));
        int ageConstraint = Integer.parseInt(request.getParameter("age_constr"));
        int promoGroupId = DAOFactory.getINSTANCE().getPromotionGroupDAO().getByName(request.getParameter("promo_group_select")).getId();
        int concertHallId = DAOFactory.getINSTANCE().getConcertHallDAO().getByName(request.getParameter("concert_hall_select")).getId();
        String description = request.getParameter("descr");
        DAOFactory.getINSTANCE().getConcertDAO().update(id, concertHallId, promoGroupId, date, description, ageConstraint, artist);
    }
}
