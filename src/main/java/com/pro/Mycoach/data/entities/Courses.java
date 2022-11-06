package com.pro.Mycoach.data.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;



@Entity
@Table(name = "\"Courses\"")
public class Courses extends BaseEntity{
    @NotNull
    protected String title;
    @NotNull
    protected float price;
    @NotNull
    protected Data documents;

    public Courses(String title, float price, Data documents) {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Data getDocuments() {
        return documents;
    }

    public void setDocuments(Data documents) {
        this.documents = documents;
    }

    @ManyToOne
    @NotNull
    private Coach coach;


    @OneToOne(cascade = CascadeType.ALL)
    private Posts posts;
}
