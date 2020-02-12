package com.myjava.choujiang.Bean;


import org.springframework.stereotype.Component;

@Component
public class Sheet1 {
    private Integer id;
    private String sid;
    private String sname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
