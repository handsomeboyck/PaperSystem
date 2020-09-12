package com.ccnu.paper_service.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: ck
 * @Description: 原告信息表
 * @Date: Create in 10:39 2020/7/14
 */
public class Accuser {
    private Integer id;
    private String name; //姓名
    private  String address; //地址
    private  String principal;  //负责人
    @JsonProperty("principal_position")
    private String principalPosition; //负责人职位

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPrincipalPosition() {
        return principalPosition;
    }

    public void setPrincipalPosition(String principalPosition) {
        this.principalPosition = principalPosition;
    }
}
