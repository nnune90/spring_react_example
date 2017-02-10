package com.allstate.repositories;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by thomas.fowler on 2/9/17.
 */
public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {
    @Query("SELECT DISTINCT s FROM Student s JOIN s.klasses k JOIN k.teacher t WHERE t.id = :id")
    public List<Student> findAllStudentsTaughtByTeacherId(@Param("id") int id);
    public List<Teacher> findByGender(Gender gender);
    public List<Teacher> findByAgeGreaterThan(int age);
    public Teacher findByName(String name);
}
