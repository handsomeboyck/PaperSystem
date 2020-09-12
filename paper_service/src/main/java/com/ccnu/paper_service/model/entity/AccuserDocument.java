package com.ccnu.paper_service.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: ck
 * @Description: 原告-文书 关联类
 * @Date: Create in 10:43 2020/7/14
 */
public class AccuserDocument {
    private Integer id;
    @JsonProperty("accuser_id")
    private Integer accuserId;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccuserId() {
        return accuserId;
    }

    public void setAccuserId(Integer accuserId) {
        this.accuserId = accuserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
