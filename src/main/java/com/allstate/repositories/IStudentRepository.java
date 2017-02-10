package com.allstate.repositories;

import com.allstate.entities.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by thomas.fowler on 2/9/17.
 */
public interface IStudentRepository extends CrudRepository<Student, Integer> {
    public Student findByEmail(String email);
}
