package com.chinasofti.pojo;

import java.io.Serializable;

public class Favorite implements Serializable {
    Router router;
    User user;
    String date;

    public Favorite() {
    }

    public Favorite(Router router, User user, String date) {
        this.router = router;
        this.user = user;
        this.date = date;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
