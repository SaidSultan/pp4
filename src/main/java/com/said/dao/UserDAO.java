package com.said.dao;

import com.said.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    void deleteUSer(long id);
    User getUserById(long id);
    List<User> getAllUsers();
}
