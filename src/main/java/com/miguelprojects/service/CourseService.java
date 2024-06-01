package com.miguelprojects.service;

import com.miguelprojects.model.Course;
import com.miguelprojects.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse (Course courseRequest){

        Course newCourse = new Course();
        newCourse.setCourseCode(courseRequest.getCourseCode());
        newCourse.setCourseName(courseRequest.getCourseName());

        return courseRepository.save(newCourse);
    }
}
