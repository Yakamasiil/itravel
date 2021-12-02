package com.chinasofti.pojo;

import java.io.Serializable;

public class Category  implements Serializable {
    private Integer cid;//编号
    private String cname;//名称

    public Category() {

    }

    public Category(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
