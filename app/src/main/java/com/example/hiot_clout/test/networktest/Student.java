package com.example.hiot_clout.test.networktest;

import java.io.Serializable;

public class Student implements Serializable {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int id;

    /**
     * 身高
     */
    private int hight;

    /**
     * 毕业
     */
    private boolean graduation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public boolean isGraduation() {
        return graduation;
    }

    public void setGraduation(boolean graduation) {
        this.graduation = graduation;
    }
}
