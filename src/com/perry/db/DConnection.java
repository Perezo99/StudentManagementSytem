package com.perry.db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DConnection {
    static Connection conn;

    public static Connection createConnection(){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          String user = "your own mysql username";

          String pass = "your own mysql password";

          String url = "jdbc:mysql://localhost:3306/student?allowPublicKeyRetrieval=True&useSSL=false";
          conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }
}
