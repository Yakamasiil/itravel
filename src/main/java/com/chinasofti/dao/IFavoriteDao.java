package com.chinasofti.dao;

import com.chinasofti.pojo.Favorite;

import java.util.List;

public interface IFavoriteDao {
    Favorite findFavoriteByRidAndUid(int uid,int rid);

    int fCount(int rid);

    int addFavorite(Favorite favorite);

    List<Favorite> findAllFavoriteById(int uid);

}
