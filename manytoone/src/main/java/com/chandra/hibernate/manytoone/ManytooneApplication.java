package com.chandra.hibernate.manytoone;

import com.chandra.hibernate.manytoone.config.AppConfig;
import com.chandra.hibernate.manytoone.dao.CourseDao;
import com.chandra.hibernate.manytoone.dao.InstructorDao;
import com.chandra.hibernate.manytoone.models.Course;
import com.chandra.hibernate.manytoone.models.Instructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class ManytooneApplication {

	// adding multiple courses for an instructor and to the table
	// while adding to proxy objects
	public static void main(String[] args) {

		//SpringApplication.run(ManytooneApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		InstructorDao instructorDao = (InstructorDao) context.getBean("instructorRepository");
		CourseDao courseDao = (CourseDao) context.getBean("courseRepository");

		//Instructor instructor = new Instructor("Pramod Sunagar", 100000);
		//instructorDao.saveInstructor(instructor);


		List <Course> courses = new ArrayList<Course>();
		Course algo = new Course("Intro to Algos");
		Course ec = new Course("Intro to Electronics and Communications");
		Course mp = new Course("Intro to Micro Processors");
		courses.add(algo);
		courses.add(ec);
		courses.add(mp);

		/* important : managing sessions and proxy objects are difficult */
		instructorDao.addCourses(2, courses);
	}
}
