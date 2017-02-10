package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value={"/sql/seed.sql"})
public class TeacherServiceTest {

    @Autowired
    private TeacherService service;

    @Test
    public void shouldCreateNewTeacher() throws Exception {
        Teacher before = new Teacher("alice", 22, Gender.FEMALE);
        Teacher after = this.service.create(before);
        assertEquals(4, after.getId());
        assertEquals("alice", after.getName());
        assertEquals(Gender.FEMALE, after.getGender());
    }

    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher teacher = this.service.findById(1);
        assertEquals(1, teacher.getId());
        assertEquals("t1", teacher.getName());
    }

    @Test
    public void shouldFindTeacherByName() throws Exception {
        Teacher teacher = this.service.findByName("t2");
        assertEquals(2, teacher.getId());
        assertEquals("t2", teacher.getName());
    }

    @Test
    public void shouldFindTeacherByGender() throws Exception {
        List<Teacher> teachers = this.service.findByGender(Gender.FEMALE);
        assertEquals(2, teachers.size());
    }

    @Test
    public void shouldFindTeacherByAgeGreaterThan() throws Exception {
        List<Teacher> teachers = this.service.findByAgeGreaterThan(50);
        assertEquals(1, teachers.size());
    }

    @Test
    @Transactional
    public void shouldFindAllTheKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.service.findById(2).getKlasses();
        assertEquals(2, klasses.size());
    }

    @Test
    @Transactional
    public void shouldFindNoKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.service.findById(3).getKlasses();
        assertEquals(0, klasses.size());
    }
}