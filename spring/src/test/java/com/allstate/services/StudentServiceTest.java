package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value={"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    public void shouldCreateStudent() throws Exception {
        Student after = this.service.create("ricky.bobby@allstate.com");
        assertEquals("ricky.bobby@allstate.com", after.getEmail());
    }

    @Test
    @Transactional
    public void shouldFindStudentById() throws Exception {
        Student found = this.service.findById(1);
        assertEquals("ricky.bobby@allstate.com", found.getEmail());
    }

    @Test
    public void shouldFindStudentByEmail() throws Exception {
        Student found = this.service.findByEmail("ricky.bobby@allstate.com");
        assertEquals(1, found.getId());
    }
}
