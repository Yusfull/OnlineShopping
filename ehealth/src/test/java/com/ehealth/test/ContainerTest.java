package com.ehealth.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ehealth.infrustructure.RepositoryConfig;
import com.ehealth.infrustructure.SecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RepositoryConfig.class, SecurityConfig.class})
public class ContainerTest {

	@Test
	public void test() {
		System.out.println("Hello World");
	}

}
