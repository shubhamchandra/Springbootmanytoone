package com.chandra.hibernate.manytoone;

import com.chandra.hibernate.manytoone.config.AppConfig;
import com.chandra.hibernate.manytoone.dao.InstructorDao;
import com.chandra.hibernate.manytoone.models.Course;
import com.chandra.hibernate.manytoone.models.Instructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ManyToOneRetrieve {
    public static void main(String ... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        InstructorDao instructorDao = (InstructorDao) context.getBean("instructorRepository");
        Instructor instructor = instructorDao.getInstructorById(2);
        System.out.println(instructor); // lazy loaded , courses are not loaded since we don't look for them
        List<Course> courses = instructor.getCourses(); // printing this would give an err
        // lazyinitializationexception
    }
}
