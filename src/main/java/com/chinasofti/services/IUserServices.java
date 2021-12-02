package com.chinasofti.services;

import com.chinasofti.pojo.User;

public interface IUserServices {
    User login(String userName,String password);
    boolean register(User user);
    boolean checkUserName(String uname);
    User findUserByCode(String code);

    int updateUserById(Integer uid);
}
