package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Department;
import com.allstate.enums.Gender;
import com.allstate.repositories.IKlassRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value={"/sql/seed.sql"})
public class KlassServiceTest {

    @Autowired
    private KlassService klassService;

    @Autowired
    private TeacherService teacherService;

    @Test
    public void create() throws Exception {
        Klass klass = new Klass("Biology 101", Date.valueOf(LocalDate.now()), 4, Department.SCIENCE, 300.0);
        Teacher teacher = teacherService.findById(1);
        klass.setTeacher(teacher);
        klass = this.klassService.create(klass);
        assertEquals(4, klass.getId());
    }

    @Test
    @Transactional
    public void shouldFindKlassById() throws Exception {
        Klass klass = this.klassService.findById(1);
        assertEquals(1, klass.getId());
    }

    @Test
    public void shouldFindKlassByName() throws Exception {
        Klass klass = this.klassService.findByName("Physics 101");
        assertEquals(1, klass.getId());
    }

    @Test
    public void shouldFindTheTeacherFromKlass() throws Exception {
        Klass klass = this.klassService.findByName("Physics 101");
        assertEquals("t1", klass.getTeacher().getName());
    }

}