/*
package com.said.service;

import com.said.dao.UserHibernateDAO;
import com.said.model.User;
import com.said.util.HiberDBHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HiberUserService implements UserService{
    private static HiberUserService hiberUserService;
    private UserHibernateDAO hibernateDAO;

    private HiberUserService() {
        hibernateDAO = new UserHibernateDAO();
    }
    public static HiberUserService getInstance() {
        if(hiberUserService == null) {
            hiberUserService = new HiberUserService();
        }
        return hiberUserService;
    }
    @Override
    public List<User> getAllUsers() {
        return hibernateDAO.getAllUsers();
    }
    @Override
    public User getUserById(long id) {
        return hibernateDAO.getUserById(id);
    }
    @Override
    public void addUser(User user) {
        hibernateDAO.addUser(user);
    }
    @Override
    public void updateUser(User user) {
        hibernateDAO.updateUser(user);
    }
    @Override
    public void deleteUser(User user) {
        hibernateDAO.deleteUSer(user.getId());
    }
}
*/
