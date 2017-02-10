package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Registration;
import com.allstate.entities.Student;
import com.allstate.repositories.IKlassRepository;
import com.allstate.repositories.IRegistrationRepository;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@Service
public class KlassService {
    private IKlassRepository klassRepository;
    private IStudentRepository studentRepository;
    private IRegistrationRepository registrationRepository;

    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setRegistrationRepository(IRegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Autowired
    public void setKlassRepository(IKlassRepository repository) {
        this.klassRepository = repository;
    }

    public Klass create(Klass klass) {
        return this.klassRepository.save(klass);
    }

    public Iterable<Klass> findAll() {
        return this.klassRepository.findAll();
    }

    public Klass findById(int id) {
        return this.klassRepository.findOne(id);
    }

    public Klass findByName(String name) {
        return this.klassRepository.findByName(name);
    }

    public Registration addStudent(int klassId, int studentId) {
        Klass klass = this.klassRepository.findOne(klassId);
        Student student = this.studentRepository.findOne(studentId);
        Registration registration = new Registration(student, klass);
        return this.registrationRepository.save(registration);
    }
}
