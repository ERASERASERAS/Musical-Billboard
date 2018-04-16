package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(checkUser(login, password)) {
            User user = DAOFactory.getINSTANCE().getUserDAO().getUserByLogin(login);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/hello.jsp");
        } else {
            req.getSession().setAttribute("loginFailed", true);
            resp.sendRedirect("/index.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        resp.sendRedirect("/billboard/login.jsp");
    }

    public boolean checkUser(String login, String password) {
        boolean result = true;

        if(login == null || password == null  || login.isEmpty() || password.isEmpty()) {
            result = false;
        } else {
            User user = DAOFactory.getINSTANCE().getUserDAO().getUserByLogin(login);
            if(user == null) {
                result = false;
            }
            else if(!password.equals(user.getPassword())){
                result = false;
            }
        }

        return result;
    }

}
