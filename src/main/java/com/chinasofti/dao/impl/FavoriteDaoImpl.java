package com.chinasofti.dao.impl;

import com.chinasofti.dao.BaseDao;
import com.chinasofti.dao.IFavoriteDao;
import com.chinasofti.pojo.Favorite;
import com.chinasofti.pojo.Router;
import com.chinasofti.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDaoImpl extends BaseDao implements IFavoriteDao {
    @Override
    public Favorite findFavoriteByRidAndUid(int uid, int rid) {
        Favorite favorite = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        try {
            con = super.getCon();
            String sql = "select * from tab_favorite where rid=? and uid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, rid);//在此设置上面的问号
            pst.setInt(2, uid);
            res = pst.executeQuery();
            if (res.next()) {
                favorite = new Favorite();
                User user = new User();
                Router router = new Router();
                user.setUid(res.getInt("uid"));
                favorite.setUser(user);
                favorite.setDate(res.getString("date"));
                router.setRidint(res.getInt("rid"));
                favorite.setRouter(router);
                return favorite;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            {
                super.close(con, pst, res);
            }
        }
        return null;
    }

    @Override
    public int fCount(int rid) {
        int count = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        try {
            con = super.getCon();
            String sql = "select count(1) from tab_favorite where rid = ? ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, rid);//在此设置上面的问号
            res = pst.executeQuery();
            if (res.next()) {
                count = res.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            {
                super.close(con, pst, res);
            }
        }
        return 0;
    }

    @Override
    public int addFavorite(Favorite favorite) {
        int count = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = super.getCon();
            String sql = "insert into tab_favorite(rid,date,uid) values(?,now(),?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, favorite.getRouter().getRid());//在此设置上面的问号
            pst.setInt(2, favorite.getUser().getUid());
            count = pst.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            {
                super.close(con, pst, null);
            }
        }
        return count;

    }


    @Override
    public List<Favorite> findAllFavoriteById(int uid) {
        List<Favorite> favorite= null;
        Favorite fav=null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        try {
            con = super.getCon();
            String sql = "select * from tab_favorite where uid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, uid);
            res = pst.executeQuery();
            favorite = new ArrayList<>();
            while(res.next()) {
                fav=new Favorite();

                Router router = new Router();
                fav.setDate(res.getString("date"));
                router.setRid(res.getInt("rid"));
                fav.setRouter(router);
                favorite.add(fav);

            }
            return favorite;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            {
                super.close(con, pst, res);
            }
        }
        return null;
    }
}
