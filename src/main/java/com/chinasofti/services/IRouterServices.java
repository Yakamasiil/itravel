package com.chinasofti.services;

import com.chinasofti.pojo.Router;

import java.util.List;

public interface IRouterServices {
    List<Router> findALLRouterPage(Integer cid,int pageSize, int PageNo);//每页多少条，显示第几页
    Router findRouterById(Integer rid);//根据路线id找信息
    Integer totalCount(Integer cid);
}
