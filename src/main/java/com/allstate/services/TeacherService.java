package com.allstate.services;

import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@Service
public class TeacherService {

    private ITeacherRepository teacherRepository;

    @Autowired
    public void setRepository(ITeacherRepository repository) {
        this.teacherRepository = repository;
    }

    public Teacher create(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    public Teacher findById(int id) {
        return this.teacherRepository.findOne(id);
    }

    public Teacher findByName(String name) {
        return this.teacherRepository.findByName(name);
    }

    public List<Teacher> findByGender(Gender gender) {
        return this.teacherRepository.findByGender(gender);
    }

    public List<Teacher> findByAgeGreaterThan(int age) {
        return this.teacherRepository.findByAgeGreaterThan(age);
    }

    public List<Student> findAllStudentsTaughtByTeacherId(int id) {
        return this.teacherRepository.findAllStudentsTaughtByTeacherId(id);
    }
}
