package com.chinasofti.services.impl;

import com.chinasofti.dao.IRouterDao;
import com.chinasofti.dao.impl.RouterDaoImpl;
import com.chinasofti.pojo.Router;
import com.chinasofti.services.IRouterServices;

import java.util.List;

public class RouterServiceImpl implements IRouterServices {
    IRouterDao routerDao=new RouterDaoImpl();
    @Override
    public List<Router> findALLRouterPage(Integer cid,int pageSize, int PageNo) {
        return routerDao.findALLRouterPage(cid,pageSize,PageNo);
    }

    @Override
    public Router findRouterById(Integer rid) {
        return routerDao.findRouterById(rid);
    }

    @Override
    public Integer totalCount(Integer cid) {
        return routerDao.totalCount(cid);
    }
}
