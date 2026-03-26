package com.student.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
            // DB URL, username, password
            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root";
            String password = "Revan@123"; // password

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}