package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    private int studentId;
    private String name;
    private int age;
    private String nationality;
    private String major;

    public Student(){

    }

    public Student(int studentId, String name, int age, String nationality, String major) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.major = major;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
