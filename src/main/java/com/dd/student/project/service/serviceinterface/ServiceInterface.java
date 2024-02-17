package com.dd.student.project.service.serviceinterface;

import com.dd.student.project.model.Student;

import java.util.Collection;

public interface ServiceInterface {
    public Iterable<Student> getStudents();

    public Student getById(Integer id);

    public Student create(Student student);

    public void remove(Integer id);
}
