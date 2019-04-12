package com.fenger.sys.utils;

import java.util.List;

public class DataGirdView {
    private Integer code;
    private String msg;
    private Long count;
    private List<?> data;


    public DataGirdView(Integer code, String msg, Long count, List<?> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public DataGirdView() {
    }
}
