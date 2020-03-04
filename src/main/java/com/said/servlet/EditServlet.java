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

@WebServlet("/edit")
public class EditServlet  extends HttpServlet {
    UserService userService = UserServiceClass.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("user", userService.getUserById(Long.parseLong(req.getParameter("editBtn"))));
        req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String lastNmae = req.getParameter("lastname");
        Byte age = Byte.parseByte(req.getParameter("age"));
        User user = new User(id, name, lastNmae, age);

        if(id == null || name == null || lastNmae == null || age == null ) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Не корректно введены данные");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            //service.updateUser(user);
            userService.updateUser(user);
            resp.sendRedirect("/users");
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
