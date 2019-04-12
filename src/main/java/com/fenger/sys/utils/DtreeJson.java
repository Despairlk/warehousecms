package com.fenger.sys.utils;

import java.util.List;

public class DtreeJson {

private Integer code;
private String msg;
private List<DtreeNode> data;

    public DtreeJson() {
    }

    public DtreeJson(Integer code, String msg, List<DtreeNode> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public List<DtreeNode> getData() {
        return data;
    }

    public void setData(List<DtreeNode> data) {
        this.data = data;
    }
}
