package com.said.servlet;

import com.said.model.User;
import com.said.service.UserService;
import com.said.service.UserServiceClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    UserService userService = UserServiceClass.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userService.getAllUsers();
        req.setAttribute("list", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastname");
        Byte age = Byte.parseByte(req.getParameter("age"));
        User user = new User(name, lastName, age);
        if(name == null || lastName == null || age == null) {
            resp.setContentType("text/html; charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        else{

            userService.addUser(user);
            resp.sendRedirect("/users");
            resp.setStatus(HttpServletResponse.SC_OK);
        }

    }
}
