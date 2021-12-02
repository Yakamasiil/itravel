package com.chinasofti.services.impl;

import com.chinasofti.dao.IUserDao;
import com.chinasofti.dao.impl.UserDaoDaoImpl;
import com.chinasofti.pojo.User;
import com.chinasofti.services.IUserServices;
import com.chinasofti.util.MailUtils;
import com.chinasofti.util.Md5Util;
import com.chinasofti.util.UuidUtil;

public class UserServiceImpl implements IUserServices {
    IUserDao userDao =new UserDaoDaoImpl();
    @Override
    public User login(String userName, String password) {
        User user=userDao.getUser(userName);
        if(user!=null){
            try {
                password=Md5Util.encodeByMd5(password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //邮箱激活业务处理


            if (user.getPassword().equals(password)&&user.getStatus()==1) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        try {
            String md5Pwd= Md5Util.encodeByMd5(user.getPassword());
            user.setPassword(md5Pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String code= UuidUtil.getUuid();
        user.setCode(code);

        int count =userDao.insertUser(user);
        String href="<a href='http://localhost:8088/travel/user?action=activeAccount&code="+code+"'>请点击激活账户</a>";
        MailUtils.sendMail(user.getEmail(),href,"账户激活邮件");
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUserName(String uname) {
        User user=userDao.getUser(uname);
        if(user!=null)return true;
        return false;
    }

    @Override
    public User findUserByCode(String code) {
        return userDao.findUserByCode(code);
    }

    @Override
    public int updateUserById(Integer uid) {
        return userDao.updateUserById(uid);
    }
}
