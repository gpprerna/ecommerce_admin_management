package com.cs114127134.ecomadmin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private int cid;
    private String name;
    private String shipDate;
    private int price;
    private int eid;

    public product() {
        super();
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return this.cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return this.name
;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getShipDate() {
        return this.shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice (int price) {
        this.price = price;
    }

    public int getEid() {
        return this.eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "{" +
                " pid='" + getPid() + "'" +
                ", cid='" + getCid() + "'" +
                ", name='" + getName() + "'" +
                ", shipDate='" + getShipDate() + "'" +
                ", price='" + getPrice() + "'" +
                ", eid='" + getEid() + "'" +
                "}";
    }

}
