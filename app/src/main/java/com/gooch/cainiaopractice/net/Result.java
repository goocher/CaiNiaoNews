package com.gooch.cainiaopractice.net;

import java.io.Serializable;

/**
 * <pre>
 *     author : gooch
 *     e-mail : zhaoguangchao@100tal.com
 *     time   : 2017/08/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class Result<T> implements Serializable {
    private String rlt;
    private String msg;
    private String code;
    private T data;

    public String getRlt() {
        return rlt;
    }

    public void setRlt(String rlt) {
        this.rlt = rlt;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "rlt='" + rlt + '\'' +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
