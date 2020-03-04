package com.said.servlet;

import com.said.model.User;
import com.said.service.UserService;
import com.said.service.UserServiceClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
    UserService userService = UserServiceClass.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("deleteBtn"));
        User user = userService.getUserById(id);
        if(id == null) {
            resp.setContentType("text/html; charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            //service.deleteUser(user);
            userService.deleteUser(user);
            resp.sendRedirect("/users");
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
