package com.pro.Mycoach.data.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"Athelets\"")
public class Athelets extends Users{
    public Athelets() {
        super(username, password, Name, description, emailAddress);
    }
}
