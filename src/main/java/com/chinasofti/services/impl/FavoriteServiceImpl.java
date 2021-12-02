package com.chinasofti.services.impl;

import com.chinasofti.dao.IFavoriteDao;
import com.chinasofti.dao.IRouterDao;
import com.chinasofti.dao.impl.FavoriteDaoImpl;
import com.chinasofti.dao.impl.RouterDaoImpl;
import com.chinasofti.pojo.Favorite;
import com.chinasofti.services.IFavoriteService;

import java.util.ArrayList;
import java.util.List;

public class FavoriteServiceImpl implements IFavoriteService {
    IFavoriteDao iFavoriteDao=new FavoriteDaoImpl();
    IRouterDao routerDao=new RouterDaoImpl();
    @Override
    public Favorite findFavoriteByRidAndUid(int uid, int rid) {
        return iFavoriteDao.findFavoriteByRidAndUid(uid, rid);
    }

    @Override
    public int fCount(int rid) {
        return iFavoriteDao.fCount(rid);
    }

    @Override
    public int addFavorite(Favorite favorite) {
        return iFavoriteDao.addFavorite(favorite);
    }

    @Override
    public List<Favorite> findAllFavoriteById(int uid) {
        List<Favorite> list=iFavoriteDao.findAllFavoriteById(uid);
        List<Favorite> listn=new ArrayList<>();
        System.out.println(list.size());
        for (int i=0;i< list.size();i++){
            Favorite favorite=list.get(i);
            favorite.setRouter(routerDao.findRouterById(favorite.getRouter().getRid()));
            listn.add(favorite);
        }
        return listn;
    }
}
