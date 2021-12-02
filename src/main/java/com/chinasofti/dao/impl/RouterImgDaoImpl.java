package com.chinasofti.dao.impl;

import com.chinasofti.dao.BaseDao;
import com.chinasofti.dao.IRouterImageDao;
import com.chinasofti.pojo.RouteImg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouterImgDaoImpl extends BaseDao implements IRouterImageDao {
    @Override
    public List<RouteImg> findRouteById(int rid) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        List<RouteImg> list = null;

        try {
            con=super.getCon();
            String sql = "select * from tab_route_img where rid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1,rid);
            res = pst.executeQuery();
            list=new ArrayList<>();

            while (res.next()){
                RouteImg routeImg=new RouteImg();
                routeImg.setRgid(res.getInt("rgid"));
                routeImg.setRid(res.getInt("rid"));
                routeImg.setBigPic(res.getString("bigpic"));
                routeImg.setSmallPic(res.getString("smallpic"));
                list.add(routeImg);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ;
        }
        return null;
    }
}
