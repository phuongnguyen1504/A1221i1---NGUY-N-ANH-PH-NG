package com.picture.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BadWord {
    @Id
    private int id;
    private String val;

    public BadWord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
