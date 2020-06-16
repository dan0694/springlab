package com.example.controller;

import com.example.demo.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> list(){
        return service.listAll();
    }

    @PostMapping("/add")
    public void add(Student s){
        service.save(s);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@RequestBody Student s, @PathVariable Integer id){
        try {
            Student existingStudent = service.get(id);
            service.save(existingStudent);
            return new ResponseEntity<Student>(s, HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id){
        try{
            Student s = service.get(id);
            return new ResponseEntity<Student>(s, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

}
