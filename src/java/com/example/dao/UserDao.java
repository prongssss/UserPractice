/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.model.UserBean;
import com.example.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asi
 */
public class UserDao {
    public static boolean isValidUser(UserBean user){
        boolean retVar = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(""+"select * from user where username=? and password=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                retVar = true;
            }
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        return retVar;
    }
    public static boolean addUser(UserBean user){
        boolean retVar = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(""+"insert into user (username, password) values (?,?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
            retVar = true;
            stmt.close();
            db.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return retVar;
    }
    public static boolean deleteUser(UserBean user){
        boolean retVar = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(""+"delete from user where userid=?");
            stmt.setString(1,""+user.getUserid());
            stmt.executeUpdate();
            retVar=true;
            stmt.close();
            db.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        return retVar;
    }
    public static boolean updateUser(UserBean user){
        boolean retVar = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(""+"update user set username=?, password=? where userid=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, ""+user.getUserid());
            stmt.executeUpdate();
            retVar = true;
            stmt.close();
            db.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        return retVar;
    }
    public static List<UserBean> getAllUsers(){
        List<UserBean> userList = new ArrayList();
        UserBean user = null;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(""+"select * from user");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                user = new UserBean();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
                user = null;
            }
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        return userList;
    }
    public static UserBean getUserById(int id){
        UserBean user = new UserBean();
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(""+"select * from user where userid=?");
            stmt.setString(1, ""+id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return user;
    }
    
    
    public static void main(String args[]){
        List<UserBean> userList = new ArrayList();
        UserBean user = null;
        userList = getAllUsers();
        for(int i = 0; i < userList.size(); i++){
            user = userList.get(i);
            System.out.println(user.toString());
            user = null;
        }
    }
}
