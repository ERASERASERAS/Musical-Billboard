package com.ssau.servlets;

import com.ssau.dao.DAOFactory;
import com.ssau.model.User;

import javax.servlet.RequestDispatcher;
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

        if(checkValidation(login, password)) {

            if(req.getParameter("doLogin") != null && checkLogIn(login, password)) {
                User user = DAOFactory.getINSTANCE().getUserDAO().getUserByLogin(login);
                String s = req.getContextPath();
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/");
            } else if (req.getParameter("doRegister") != null && checkRegistration(login,password)) {
                 DAOFactory.getINSTANCE().getUserDAO().addUser(9,login, password, "USER");
                //todo исправить добавление (id)  и скрипт с уведомлениями об авторизации и регистрации identity в бд на pk
                resp.sendRedirect("/");
            }
            else {
                req.getSession().setAttribute("loginFailed", true);
                //resp.sendRedirect("index.jsp");
                resp.sendRedirect("/");
            }


        } else {
            req.getSession().setAttribute("loginFailed", true);
            resp.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        req.getRequestDispatcher("login.jsp").forward(req,resp);

    }

    public boolean checkValidation(String login, String password) {
         return !(login == null || password == null  || login.isEmpty() || password.isEmpty());
    }

    public boolean checkLogIn(String login, String password) {
        return DAOFactory.getINSTANCE().getUserDAO().getUserByLogin(login)!= null
                && DAOFactory.getINSTANCE().getUserDAO().getUserByLogin(login).getPassword().equals(password);
    }

    public boolean checkRegistration(String login, String password) {
        return DAOFactory.getINSTANCE().getUserDAO().getUserByLogin(login) == null;
    }

}
