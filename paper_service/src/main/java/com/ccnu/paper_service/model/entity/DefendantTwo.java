package com.ccnu.paper_service.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: ck
 * @Description:  被告（双人诉讼） 与律师类相关联
 * @Date: Create in 10:42 2020/7/14
 */
public class DefendantTwo {
    private Integer id;
    @JsonProperty("one_name")
    private String oneName;
    @JsonProperty("one_sex")
    private String oneSex;
    @JsonProperty("one_address")
    private String oneAddress;
    @JsonProperty("one_nature")
    private String oneNature;
    @JsonProperty("one_card_num")
    private String OneCardNum;  //一号被告身份证号
    @JsonProperty("two_name")
    private String twoName;
    @JsonProperty("two_sex")
    private String twoSex;
    @JsonProperty("two_address")
    private String twoAddress;
    @JsonProperty("two_nature")
    private String twoNature;
    @JsonProperty("two_card_num")
    private String twoCardNum; //二号被告身份证号
    @JsonProperty("lawyer_id")
    private Integer lawyerId; //律师编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOneName() {
        return oneName;
    }

    public void setOneName(String oneName) {
        this.oneName = oneName;
    }

    public String getOneSex() {
        return oneSex;
    }

    public void setOneSex(String oneSex) {
        this.oneSex = oneSex;
    }

    public String getOneAddress() {
        return oneAddress;
    }

    public void setOneAddress(String oneAddress) {
        this.oneAddress = oneAddress;
    }

    public String getOneNature() {
        return oneNature;
    }

    public void setOneNature(String oneNature) {
        this.oneNature = oneNature;
    }

    public String getOneCardNum() {
        return OneCardNum;
    }

    public void setOneCardNum(String oneCardNum) {
        OneCardNum = oneCardNum;
    }

    public String getTwoName() {
        return twoName;
    }

    public void setTwoName(String twoName) {
        this.twoName = twoName;
    }

    public String getTwoSex() {
        return twoSex;
    }

    public void setTwoSex(String twoSex) {
        this.twoSex = twoSex;
    }

    public String getTwoAddress() {
        return twoAddress;
    }

    public void setTwoAddress(String twoAddress) {
        this.twoAddress = twoAddress;
    }

    public String getTwoNature() {
        return twoNature;
    }

    public void setTwoNature(String twoNature) {
        this.twoNature = twoNature;
    }

    public String getTwoCardNum() {
        return twoCardNum;
    }

    public void setTwoCardNum(String twoCardNum) {
        this.twoCardNum = twoCardNum;
    }

    public Integer getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(Integer lawyerId) {
        this.lawyerId = lawyerId;
    }
}
