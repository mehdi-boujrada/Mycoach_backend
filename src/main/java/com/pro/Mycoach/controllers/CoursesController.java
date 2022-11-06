package com.pro.Mycoach.controllers;

import com.pro.Mycoach.data.entities.Courses;
import com.pro.Mycoach.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/course")
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @PostMapping("/courses")
    public boolean createCourses(@RequestBody Courses dto) {
        if (!check(dto))
            return false;

        coursesService.createCourses(dto.getTitle(), dto.getPrice(), dto.getDocuments());
        return true;
    }

    private boolean check(Courses dto) {
        return false;
    }
}
