package com.chinasofti.dao;

import java.sql.*;

public class BaseDao {
    public Connection getCon()  {
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1:3306/travel?useUnicode=true&characterEncoding=UTF-8";
            con= DriverManager.getConnection(url,"root","123456");
            System.out.println("连接成功");
            return con;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  con;
    }
    public void close(Connection con, Statement st, ResultSet res){
        if(res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
