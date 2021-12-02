package com.chinasofti.dao.impl;

import com.chinasofti.dao.BaseDao;
import com.chinasofti.dao.IUserDao;
import com.chinasofti.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoDaoImpl extends BaseDao implements IUserDao {

    @Override
    public User getUser(String userName) {
        User user=null;
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet res=null;
        try {
            con= super.getCon();
            String sql="select * from tab_user where username=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,userName);//在此设置上面的问号
            res=pst.executeQuery();
            if(res.next()){
               user=new User();
               user.setUid(res.getInt("uid"));
               user.setUserName(res.getString("username"));
               user.setBirthday(res.getString("birthday"));
               user.setCode(res.getString("code"));
               user.setEmail(res.getString("email"));
               user.setPassword(res.getString("password"));
               user.setName(res.getString("name"));
               user.setSex(res.getInt("sex"));
               user.setTelephone(res.getString("telephone"));
               user.setStatus(res.getInt("status"));
               return user;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            {
               super.close(con,pst,res);
            }
        }

        return null;
    }


    @Override
    public int insertUser(User user) {
        int count=0;
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet res=null;

        con= super.getCon();
        String sql="INSERT INTO tab_user(username,PASSWORD,NAME,birthday,sex,telephone,email,STATUS,CODE) VALUES(?,?,?,?,?,?,?,0,?)";

        try {
            pst=con.prepareStatement(sql);

            pst.setString(1,user.getUserName());
            pst.setString(2,user.getPassword());
            pst.setString(3,user.getName());
            pst.setString(4,user.getBirthday());
            pst.setInt(5,user.getSex());
            pst.setString(6,user.getTelephone());
            pst.setString(7,user.getEmail());
            pst.setString(8,user.getCode());
            count=pst.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.close(con,pst,res);
        }

        return 0;
    }

    @Override
    public User findUserByCode(String code) { User user=null;
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet res=null;
        try {
            con= super.getCon();
            String sql="select * from tab_user where code=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,code);//在此设置上面的问号
            res=pst.executeQuery();
            if(res.next()){
                user=new User();
                user.setUid(res.getInt("uid"));
                user.setUserName(res.getString("username"));
                user.setBirthday(res.getString("birthday"));
                user.setCode(res.getString("code"));
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("password"));
                user.setName(res.getString("name"));
                user.setSex(res.getInt("sex"));
                user.setTelephone(res.getString("telephone"));
                user.setStatus(res.getInt("status"));
                return user;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            {
                super.close(con,pst,res);
            }
        }

        return null;
    }

    @Override
    public int updateUserById(Integer uid) {
        int count=0;
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet res=null;
        try {
            con= super.getCon();
            String sql="update tab_user set status=1 where uid=?";
            pst=con.prepareStatement(sql);
            pst.setInt(1,uid);//在此设置上面的问号
            count=pst.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            {
                super.close(con,pst,res);
            }
        }

        return count;
    }


}
