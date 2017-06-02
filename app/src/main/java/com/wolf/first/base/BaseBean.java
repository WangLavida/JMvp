package com.wolf.first.base;

import java.io.Serializable;

/**
 * Created by W.J on 2017/5/31.
 */

public class BaseBean<T> implements Serializable {
    public String msg;
    public T result;
    public String retCode;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
