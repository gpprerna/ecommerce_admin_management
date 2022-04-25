package com.cs114127134.ecomadmin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caid;
    private String name;
    private String des;
    private int cid;

    public category() {
        super();
    }

    public int getCaid() {
        return this.caid;
    }

    public void setCaid(int caid) {
        this.caid = caid;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDes() {
        return this.des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    public int getCid() {
        return this.cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "{" +
                " getCaid='" + getCaid() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDes() + "'" +
                ", Cid='" + getCid() + "'" +
                "}";
    }

}
