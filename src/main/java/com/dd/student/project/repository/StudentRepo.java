package com.dd.student.project.repository;

import com.dd.student.project.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {
}
