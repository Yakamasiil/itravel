package com.chinasofti.dao;

import com.chinasofti.pojo.RouteImg;

import java.util.List;

public interface IRouterImageDao {
    List<RouteImg> findRouteById(int rid);
}
