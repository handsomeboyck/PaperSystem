package com.ccnu.paper_service.model.entity;

/**
 * @Author: ck
 * @Description: 律师类
 * @Date: Create in 10:43 2020/7/14
 */
public class Lawyer {
    private Integer id;
    private String name;
    private String pwd;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
