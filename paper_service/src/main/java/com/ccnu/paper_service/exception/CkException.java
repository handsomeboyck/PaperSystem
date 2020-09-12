package com.ccnu.paper_service.exception;

/**
 * @Author: ck
 * @Description: 自定义异常
 * @Date: Create in 10:53 2020/7/8
 */
public class CkException extends RuntimeException {
    private Integer code;
    private String msg;

    public CkException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
