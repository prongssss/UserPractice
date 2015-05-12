/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.UserBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asi
 */
public class UserControllerServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("action");
        RequestDispatcher rd;

        if(str.equals("delete")){
            
            String userID = req.getParameter("userid");
            UserBean user = new UserBean();
            user.setUserid(Integer.parseInt(userID));
            UserDao.deleteUser(user);
            rd = req.getRequestDispatcher("home.jsp");
            rd.forward(req,resp);
            
        }
        else if(str.equals("edit")){
            rd = req.getRequestDispatcher("user.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("action");

        if(str.equals("delete")){
            
            String userID = req.getParameter("userid");
            UserBean user = new UserBean();
            user.setUserid(Integer.parseInt(userID));
            UserDao.deleteUser(user);
            RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
            rd.forward(req,resp);
            
        }
    }
    
    
}
