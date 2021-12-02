package com.chinasofti.services;

import com.chinasofti.pojo.RouteImg;

import java.util.List;

public interface IRouterImgService {
    List<RouteImg> findRouteById(int rid);
}
