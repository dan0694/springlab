package com.example.service;

import com.example.demo.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> listAll(){
        return repo.findAll();
    }

    public void save(Student student){
        repo.save(student);
    }

    public Student get(int id){
        return repo.findById(id).get();
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}
