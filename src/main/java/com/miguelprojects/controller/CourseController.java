package com.miguelprojects.controller;

import com.miguelprojects.model.Course;
import com.miguelprojects.repository.CourseRepository;
import com.miguelprojects.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseService courseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseByNameWhitPathVariable(@PathVariable(name = "name")String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseByNameWhitQueryParam(@RequestParam(name = "name") String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    //No me funciona el metodo post
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Course postCourse(@RequestBody Course course) {

        return courseService.createCourse(course);

    }

}