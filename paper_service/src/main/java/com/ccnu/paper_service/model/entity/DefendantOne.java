package com.ccnu.paper_service.model.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: ck
 * @Description: 被告（单人诉讼）  与律师类相关联
 * @Date: Create in 10:42 2020/7/14
 */
public class DefendantOne {
    private Integer id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "性别")
    private String sex;
    @Excel(name = "地址")
    private String address;
    @Excel(name = "民族")
    private String nature;
    @Excel(name = "身份证号")
    @JsonProperty("card_num")
    private String cardNum;
    @JsonProperty("lawyer_id")
    private Integer lawyerId;

    @Override
    public String toString() {
        return "DefendantOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", nature='" + nature + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", lawyerId=" + lawyerId +
                '}';
    }

    public Integer getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(Integer lawyerId) {
        this.lawyerId = lawyerId;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
