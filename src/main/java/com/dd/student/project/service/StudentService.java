package com.dd.student.project.service;

import com.dd.student.project.model.Student;
import com.dd.student.project.repository.StudentRepo;
import com.dd.student.project.service.serviceinterface.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentService implements ServiceInterface {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Iterable<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student create(Student student) {
        return studentRepo.save(student);
    }
}
