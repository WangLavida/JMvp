package com.wolf.first.base;

import java.io.Serializable;

/**
 * Created by W.J on 2017/5/31.
 */

public class BaseBean implements Serializable{
    public int state;
    public String error;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
