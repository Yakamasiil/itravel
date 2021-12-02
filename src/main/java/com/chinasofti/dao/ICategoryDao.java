package com.chinasofti.dao;

import com.chinasofti.pojo.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAllCategory();
}
