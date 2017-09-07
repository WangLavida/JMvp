package com.wolf.first.bean;

/**
 * Created by W.J on 2017/9/7.
 */

public class ToolInfo {
    private String name;
    private int icon;

    public ToolInfo(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
