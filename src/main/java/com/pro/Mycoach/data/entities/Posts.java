package com.pro.Mycoach.data.entities;

import javax.validation.constraints.NotNull;
import java.awt.*;
import javax.persistence.*;
import javax.persistence.OneToOne;

public class Posts extends BaseEntity{
    @NotNull
    protected String title;
    @NotNull
    protected String PostDiscription;
    @NotNull
    protected Image image;

    @OneToOne(cascade = CascadeType.ALL)
    private Courses courses;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostDiscription() {
        return PostDiscription;
    }

    public void setPostDiscription(String postDiscription) {
        PostDiscription = postDiscription;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Posts(String title, String postDiscription, Image image) {
        super();
    }
}
