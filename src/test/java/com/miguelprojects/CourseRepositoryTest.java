package com.miguelprojects;

import com.miguelprojects.model.Course;
import com.miguelprojects.model.Grade;
import com.miguelprojects.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    private Course course1;

    @BeforeEach
    void setUp() {
        course1 = new Course("CS105", "Data Structures and Algorithms");
        courseRepository.save(course1);
    }

    @AfterEach
    void tearDown() {
        courseRepository.deleteById("CS105");
    }

    @Test
    public void testJPA(){
        Optional<Course> courseFromDb = courseRepository.findById("CS105");
        assertTrue(courseFromDb.isPresent());
        assertEquals(course1, courseFromDb.get());
    }
}
