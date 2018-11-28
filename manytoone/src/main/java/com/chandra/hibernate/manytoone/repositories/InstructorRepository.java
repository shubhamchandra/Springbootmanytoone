package com.chandra.hibernate.manytoone.repositories;

import com.chandra.hibernate.manytoone.dao.CourseDao;
import com.chandra.hibernate.manytoone.dao.InstructorDao;
import com.chandra.hibernate.manytoone.models.Course;
import com.chandra.hibernate.manytoone.models.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InstructorRepository implements InstructorDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    CourseDao courseDao;

    @Override
    public List<Instructor> getAllInstructors() {
        Session session = sessionFactory.getCurrentSession();
        List <Instructor> list = session.createQuery("from Instructor").getResultList();
        return list;
    }

    @Override
    public Instructor getInstructorById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Instructor instructor = session.get(Instructor.class, id);
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println(instructor);
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        return instructor;
    }

    @Override
    public void deleteInstructor(int id) {
        Session session = sessionFactory.getCurrentSession();
        Instructor instructor = session.get(Instructor.class, id);
        List <Course> courses = instructor.getCourses();
        /* must set courses instructor to null otherwise SQL err : Foreign key constraint fails (inconsistent data)
        * */
        for(Course course : courses) {
            course.setInstructor(null);
        }
        session.delete(instructor);
    }

    @Override
    public void saveInstructor(Instructor instructor) {
        Session session = sessionFactory.getCurrentSession();
        session.save(instructor);
    }

    /* complicated */
    @Override
    public void addCourses(int id, List<Course> courses) {
        Session session = sessionFactory.getCurrentSession();
        Instructor instructor = session.get(Instructor.class, id);
        for(Course course : courses) {
            instructor.addCourse(course);
            courseDao.saveCourse(course);
        }
    }

    @Override
    public List<Course> getInstructorCourses(int id) {
        Session session = sessionFactory.getCurrentSession();
        Instructor instructor = session.get(Instructor.class, id);
        return instructor.getCourses();
    }
}
