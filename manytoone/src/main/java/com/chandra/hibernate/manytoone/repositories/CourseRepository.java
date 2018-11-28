package com.chandra.hibernate.manytoone.repositories;

import com.chandra.hibernate.manytoone.dao.CourseDao;
import com.chandra.hibernate.manytoone.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository implements CourseDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Course> getAllCourses() {
        Session session = sessionFactory.getCurrentSession();
        List <Course> list = session.createQuery("from Course").getResultList();
        return list;
    }

    @Override
    public Course getCourseById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = session.get(Course.class, id);
        return course;
    }

    @Override
    public void deleteCourse(int id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = session.get(Course.class, id);
        session.delete(course);
    }

    @Override
    public void saveCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }
}
