package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@Service
@Transactional
public class RegistrationService {

    @Autowired
    private TeacherService teacherService;

    private StudentService studentService;
    private KlassService klassService;

    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    public KlassService getKlassService() {
        return klassService;
    }

    @Autowired
    public void setKlassService(KlassService klassService) {
        this.klassService = klassService;
    }

    public Klass enroll(List<String> emails, Teacher teacher, Klass klass) {
        List<Student> students = emails.stream().map(e -> new Student(e)).collect(Collectors.toList());
        klass.setTeacher(teacher);
        klass.setStudents(students);

        this.studentService.createAll(students);
        this.teacherService.create(teacher);
        this.klassService.create(klass);

        return klass;
    }

    public Klass register(List<String> emails, Klass klass) {
        List<Student> students = emails.stream().map(e -> new Student(e)).collect(Collectors.toList());
        klass.setStudents(students);
        this.studentService.createAll(students);
        this.klassService.create(klass);

        return klass;
    }
}
