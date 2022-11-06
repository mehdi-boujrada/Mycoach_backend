package com.pro.Mycoach.data.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "\"Coachs\"")
public class Coach extends Users{

    public Coach() {
        super(username, password, Name, description, emailAddress);
    }

    protected enum sport {
        BASKETBALL, FOOTBALL, AMERICAN_FOOTBALL, LIFTING, CARDIO
    }

    @NotNull
    protected Date AdvisingDays;


}
