package com.cs114127134.ecomadmin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;
    private String name;
    private int age;
    private float salary;
    private char sex;

    public employee() {
        super();
    }

    public int getEid() {
        return this.eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "{" +
                " eid='" + getEid() + "'" +
                ", name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", salary='" + getSalary() + "'" +
                ", sex='" + getSex() + "'" +
                "}";
    }

}
