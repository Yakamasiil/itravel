package com.chinasofti.dao;

import com.chinasofti.pojo.User;

public interface IUserDao {
    /**
     * 查找用户
     * @param userName
     * @return
     */
    User getUser(String userName);

    /**
     * 增加用户
     * @param user
     * @return
     */
    int insertUser(User user);
    User findUserByCode(String code);

    int updateUserById(Integer uid);
}
