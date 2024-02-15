package com.dd.student.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class MainController {

    /*Temp database */
    Map<String, Student> returnMapData = new HashMap<>() {{
        put("1", new Student(1, "salim", "9876543212"));
        put("2", new Student(2, "Alice", "258258258"));
        put("3", new Student(3, "Mark", "1236549872"));
    }};


    @GetMapping("/")
    public String index() {
        return "Hello this is rest controller ";
    }

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> getStudents() {
        return returnMapData.values();
    }

    @GetMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable String id) {
        Student student = returnMapData.get(id);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return student;
    }
    @DeleteMapping("/delete-student/{id}")
    public void delete(@PathVariable String id) {
        Student student = returnMapData.remove(id);
        System.out.println("Student is "+ student);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
