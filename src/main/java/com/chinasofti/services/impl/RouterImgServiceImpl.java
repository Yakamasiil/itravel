package com.chinasofti.services.impl;

import com.chinasofti.dao.IRouterImageDao;
import com.chinasofti.dao.impl.RouterImgDaoImpl;
import com.chinasofti.pojo.RouteImg;
import com.chinasofti.services.IRouterImgService;

import java.util.List;

public class RouterImgServiceImpl implements IRouterImgService {
    @Override
    public List<RouteImg> findRouteById(int rid) {
        IRouterImageDao iRouterImageDao=new RouterImgDaoImpl();
        return iRouterImageDao.findRouteById(rid);
    }
}
