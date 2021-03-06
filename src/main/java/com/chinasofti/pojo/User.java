package com.chinasofti.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;
    private String userName;
    private String password;
    private String name;
    private String birthday;
    private String telephone;
    private String email;
    private Integer status;
    private String code;
    private Integer sex;



    public User() {
    }

    public User(Integer uid, String userName, String password, String name, String birthdayDate, String telephone, String email, Integer status, String code) {
        this.uid = uid;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.birthday = birthdayDate;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
        this.code = code;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", code='" + code + '\'' +
                ", sex=" + sex +
                '}';
    }
}
