package com.allstate.services;

import com.allstate.entities.Student;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@Service
public class StudentService {
    private IStudentRepository repository;

    @Autowired
    public void setRepository(IStudentRepository repository) {
        this.repository = repository;
    }

    public Student create(String email) {
        Student student = new Student(email);
        return this.repository.save(student);
    }

    public Student findById(int studentId) {
        return this.repository.findOne(studentId);
    }

    public Student findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    public Iterable<Student> createAll(List<Student> students) {
        return this.repository.save(students);
    }

    public Iterable<Student> findAll() {
        return this.repository.findAll();
    }
}
