package com.chandra.hibernate.manytoone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private int salary;

    @OneToMany(mappedBy = "instructor", cascade = { CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    List <Course> courses = null;

    public Instructor() {}

    public Instructor(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void addCourse(Course course) {
        /* ensure two way mapping */
        course.setInstructor(this);
        if(this.courses == null)
            this.courses = new ArrayList<Course>();
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
