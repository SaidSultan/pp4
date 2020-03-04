package com.said.service;

import com.said.dao.UserDAO;
import com.said.dao.UserHibernateDAO;
import com.said.factory.UserDaoFactory;
import com.said.model.User;

import java.util.List;

public class UserServiceClass implements  UserService{
    private static UserServiceClass userServiceClass;
    private UserDAO userDAO;

    private UserServiceClass() {
        userDAO = UserDaoFactory.createDAO();
    }
    public static UserServiceClass getInstance() {
        if(userServiceClass == null) {
            userServiceClass = new UserServiceClass();
        }
        return userServiceClass;
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUSer(user.getId());
    }
}
