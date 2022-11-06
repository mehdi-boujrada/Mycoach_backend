package com.pro.Mycoach.data.entities;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "\"Acquisition\"")
public class Acquisition extends BaseEntity{
    @NotNull
    protected Date PurcheseDate;

    @ManyToOne
    @NotNull
    private Courses courses;

    @ManyToOne
    @NotNull
    private Athelets athelets;
}
