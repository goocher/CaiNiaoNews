package com.gooch.cainiaopractice.net;

/**
 * <pre>
 *     author : gooch
 *     e-mail : zhaoguangchao@100tal.com
 *     time   : 2017/08/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class SimpleResult {
    private String rlt;
    private String msg;
    private String code;

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

    @Override
    public String toString() {
        return "SimpleResult{" +
                "rlt='" + rlt + '\'' +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Result convertToResult() {

        Result result = new Result();
        result.setRlt(this.rlt);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
