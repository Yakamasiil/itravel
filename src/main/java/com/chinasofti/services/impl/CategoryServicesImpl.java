package com.chinasofti.services.impl;

import com.chinasofti.dao.ICategoryDao;
import com.chinasofti.dao.impl.CategoryDaoImpl;
import com.chinasofti.pojo.Category;
import com.chinasofti.services.ICategoryService;
import com.chinasofti.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServicesImpl implements ICategoryService {
    ICategoryDao categoryDao=new CategoryDaoImpl() ;
    public List<Category> findAllCategory() {

        //从缓存中加载数据
        Jedis jedis= JedisUtil.getJedis();
        List<Category> list=null;

        Set<Tuple> categories=jedis.zrangeWithScores("category",0,-1);
        //若不存在分类数据则从数据库查询数据
        if (categories==null||categories.size()==0){
            list=new CategoryDaoImpl().findAllCategory();
            for (int i=0;i<list.size();i++){
                jedis.zadd("category",list.get(i).getCid(),list.get(i).getCname());

            }

        }else {
            int i=1;
            list=new ArrayList<>();
            for (Tuple tuple:categories){
                Category category=new Category();
                category.setCid((int)tuple.getScore());
                category.setCname(tuple.getElement());
                list.add(category);
            }
        }

        //并存储进redis
        //若缓存中存在分类数据
        //直接从缓存中读取加载分类

        return list;
    }
}
