package com.allstate;

import com.allstate.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({
    StudentServiceTest.class,
	KlassServiceTest.class,
    TeacherServiceTest.class,
    RegistrationServiceTest.class
})
public class LmsApplicationTests {

	@Test
	public void contextLoads() {
	}
}
