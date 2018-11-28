package com.chandra.hibernate.manytoone.dao;

import com.chandra.hibernate.manytoone.models.Course;

import java.util.List;

public interface CourseDao {

    List<Course> getAllCourses();

    Course getCourseById(int id);

    void deleteCourse(int id);

    void saveCourse(Course course);

}
