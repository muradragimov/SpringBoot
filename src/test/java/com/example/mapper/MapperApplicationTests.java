package com.example.mapper;

import com.example.mapper.controller.CourseController;
import com.example.mapper.dao.entity.StudentEntity;
import com.example.mapper.service.CourseService;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class MapperApplicationTests {
	@Autowired
	private CourseController controller;

	@Autowired
	private CourseService courseService;

	@Test
	@SneakyThrows
	void contextLoads() throws Throwable{

		final String baseUrl = "http://localhost:"+8080+"/controller";

		Thread thread1 = new Thread(controller);
		Thread thread2 = new Thread(controller);

		Thread thread3 = new Thread(controller);
		Thread thread4 = new Thread(controller);
		Thread thread5 = new Thread(controller);
		Thread thread6 = new Thread(controller);
		Thread thread7 = new Thread(controller);

		thread1.start();
		thread2.start();
		thread3.start();/*
		thread1.join();
		thread2.join();
		thread1.join();*/
		/*thread2.join();*/

		System.out.println("Count: "+courseService.integer);
		assertEquals("number of users created: " + courseService.integer, 2,
				courseService.integer);

	}

}
