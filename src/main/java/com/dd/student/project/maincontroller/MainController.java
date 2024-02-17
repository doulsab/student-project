package com.dd.student.project.maincontroller;

import com.dd.student.project.model.Student;
import com.dd.student.project.service.serviceinterface.ServiceInterface;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MainController {

    private final ServiceInterface serviceInterface;

    public MainController(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Student> getStudents() {
        return serviceInterface.getStudents();
    }

    @GetMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable Integer id) {
        Student student = serviceInterface.getById(id);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return student;
    }

    @DeleteMapping("/delete-student/{id}")
    public void delete(@PathVariable Integer id) {
        serviceInterface.remove(id);
    }

    @PostMapping(value = "/create-student", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student create(@RequestBody @Valid Student student) {
        return serviceInterface.create(student);
    }


}
