package com.chinasofti.dao.impl;

import com.chinasofti.dao.BaseDao;
import com.chinasofti.dao.IRouterDao;
import com.chinasofti.pojo.Router;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RouterDaoImpl extends BaseDao implements IRouterDao {

    @Override
    public List<Router> findALLRouterPage(Integer cid,int pageSize, int PageNo) {
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet res=null;
        Router router=null;
        List<Router> listr=null;
        try{
            String sql="select * from tab_route where cid=? limit ?,?";
            con=super.getCon();
            pst=con.prepareStatement(sql);
            pst.setInt(2,(PageNo-1)*pageSize);
            pst.setInt(3,pageSize);
            pst.setInt(1,cid);
            listr=new ArrayList<>();
            res=pst.executeQuery();
            while(res.next()){
                router=new Router();
                router.setRidint(res.getInt("rid"));
                router.setRid(res.getInt("rid"));
                router.setRname(res.getString("rname"));
                router.setPrice(res.getDouble("price"));
                router.setRouteIntroduce(res.getString("routeintroduce"));
                router.setRflag(res.getInt("rflag"));
                router.setRdate(res.getDate("rdate"));
                router.setIsThemeTour(res.getInt("isthemetour"));
                router.setCount(res.getInt("count"));
                router.setRimage(res.getString("rimage"));
                router.setCid(res.getInt("cid"));
                listr.add(router);
            }
            return listr;
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            super.close(con,pst,res);
        }
        return null;
    }



    @Override
    public Router findRouterById(Integer rid) {
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet res=null;
        Router router=null;

        try{
            String sql="select * from tab_route where rid=?";
            con=super.getCon();
            pst=con.prepareStatement(sql);
            pst.setInt(1,rid);
            res=pst.executeQuery();
            if (res.next()){
                router=new Router();
                router.setRidint(res.getInt("rid"));
                router.setRname(res.getString("rname"));
                router.setPrice(res.getDouble("price"));
                router.setRouteIntroduce(res.getString("routeintroduce"));
                router.setRflag(res.getInt("rflag"));
                router.setRdate(res.getDate("rdate"));
                router.setIsThemeTour(res.getInt("isthemetour"));
                router.setCount(res.getInt("count"));
                router.setRimage(res.getString("rimage"));
                router.setCid(res.getInt("cid"));
                return router;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            super.close(con,pst,res);
        }
        return null;
    }

    @Override
    public Integer totalCount(Integer cid) {
         Connection con=null;
        PreparedStatement pst=null;
        ResultSet res=null;
        Router router=null;
        int count=0;

        try{
            String sql="select count(1) from tab_route where cid=?";
            con=super.getCon();
            pst=con.prepareStatement(sql);
            pst.setInt(1,cid);
            res=pst.executeQuery();
            if (res.next()){
               count=res.getInt(1);

            }
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            super.close(con,pst,res);
        }
        return count;
    }

}
