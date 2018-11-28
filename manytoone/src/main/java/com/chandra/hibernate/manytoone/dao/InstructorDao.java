package com.chandra.hibernate.manytoone.dao;

import com.chandra.hibernate.manytoone.models.Course;
import com.chandra.hibernate.manytoone.models.Instructor;

import java.util.List;

public interface InstructorDao {

    List <Instructor> getAllInstructors();

    Instructor getInstructorById(int id);

    void deleteInstructor(int id);

    void saveInstructor(Instructor instructor);

    void addCourses(int id, List <Course> courses);

    List <Course> getInstructorCourses(int id);
}
