package com.chinasofti.dao.impl;

import com.chinasofti.dao.BaseDao;
import com.chinasofti.dao.ICategoryDao;
import com.chinasofti.pojo.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends BaseDao implements ICategoryDao {
    @Override
    public List<Category> findAllCategory() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        List<Category> listc = null;

        try {
            con=super.getCon();
            String sql = "select * from tab_category order by cid";
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();
            listc=new ArrayList<>();
            while (res.next()) {
                Category category=new Category();
                category.setCid(res.getInt("cid"));
                category.setCname(res.getString("cname"));
                listc.add(category);

            }
            return listc;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ;
        }
        return null;
    }
}
