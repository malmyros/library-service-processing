package com.example.book_service_processing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class BookServiceProcessingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void foo() {
		ApplicationModules.of(BookServiceProcessingApplication.class).verify();
	}
}
