package com.work.domain;

public class Account {

    private String sname;
    private int smoney;

    public Account() {
    }

    public Account(String sname, int smoney) {
        this.sname = sname;
        this.smoney = smoney;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSmoney() {
        return smoney;
    }

    public void setSmoney(int smoney) {
        this.smoney = smoney;
    }

    @Override
    public String toString() {
        return "domain{" +
                "sname='" + sname + '\'' +
                ", smoney=" + smoney +
                '}';
    }
}
