package com.said.util;


import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper {
    private static DBHelper dbHelper;
    private DBHelper() { }
    public  static DBHelper getDBHelper() {
        if(dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }


    public Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").
                    append("localhost:").
                    append("3306/").
                    append("Users?").
                    append("user=root&").
                    append("password=admin&").
                    append("serverTimezone=UTC");
            System.out.println("URL: " + url + "\n");
            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public SessionFactory getConfiguration() {
        return HiberDBHelper.getSessionFactory();
    }
}
