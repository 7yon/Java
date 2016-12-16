package com.spr.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "record")
public class Shop {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="user_name",nullable = false)
    private String userName;

    @Temporal(TemporalType.DATE)
    @Column(name="date",nullable = false)
    private Date remindDate;

    public Shop() {
    }

    public long getIdShop() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }

}
