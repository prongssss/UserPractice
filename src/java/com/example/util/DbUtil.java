/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asi
 */
public class DbUtil {
    private Connection connection = null;
    
    public Connection getConnection(){
        if(connection!=null){
            return connection;
        }
        else{
            try{
//                Properties prop = new Properties();
//                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                String url = prop.getProperty("url");
//                String username = prop.getProperty("username");
//                String password = prop.getProperty("password");
                String driver="com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/Users";
                String username="root";
                String password="alliance";
                Class.forName(driver);
                connection = (Connection) DriverManager.getConnection(url, username, password);
                
            
            }catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
//           } catch (IOException ex) {
//                Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            return connection;
        }
    }
    
    public void disconnect(){
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
