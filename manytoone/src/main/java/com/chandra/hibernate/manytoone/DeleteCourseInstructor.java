package com.chandra.hibernate.manytoone;

import com.chandra.hibernate.manytoone.config.AppConfig;
import com.chandra.hibernate.manytoone.dao.CourseDao;
import com.chandra.hibernate.manytoone.dao.InstructorDao;
import com.chandra.hibernate.manytoone.models.Instructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeleteCourseInstructor {
    public static void main(String ... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        /*
        CourseDao courseDao = (CourseDao) context.getBean("courseRepository");
        courseDao.deleteCourse(3); // works */

        /* Need to set instructor for the courses to null before deletion */
        InstructorDao instructorDao = (InstructorDao) context.getBean("instructorRepository");
        instructorDao.deleteInstructor(2);
    }
}
