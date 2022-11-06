package com.pro.Mycoach.services;

import com.pro.Mycoach.data.entities.Courses;
import com.pro.Mycoach.data.repositories.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;

public class CoursesService {
    @Autowired
    CoursesRepo coursesRepo;

    public void createCourses(String title, float price, Data documents) {
        Courses courses = new Courses(title, price, documents);
        coursesRepo.save(courses);
    }
}
