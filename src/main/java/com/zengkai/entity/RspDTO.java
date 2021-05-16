package com.zengkai.entity;

/**
 * 返回出参
 */
public class RspDTO {

    private String code;
    private String msg;

    public RspDTO() {
        this.code = "A001";
        this.msg = "操作成功";
    }

    public RspDTO(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
