package com.said.factory;

import com.said.dao.UserDAO;
import com.said.dao.UserDaoJDBC;
import com.said.dao.UserHibernateDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {
    public static UserDAO createDAO() {
        /*File file = new File("hibernate.properties");*/
        Properties properties = new Properties();
        try(FileInputStream file = new FileInputStream("C:\\Users\\Said\\IdeaProjects\\UserList\\src\\main\\webapp\\resources\\hibernate.properties")) {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = properties.getProperty("bdconfig");
        if(s.equals("hibernate")) {
            return new UserHibernateDAO();
        } else {
            return new UserDaoJDBC();
        }
    }
}
