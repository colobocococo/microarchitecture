package com.coloboc.client;

import com.coloboc.client.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void NotExistingOrder() throws IOException, InterruptedException {
		int id = 1500;

		assertEquals("failed", OrderService.get(id));
	}

	@Test
	void NormalOrder() throws IOException, InterruptedException {
		int id = 15;
		int user_id = 1;
		int amount = 1;

		OrderService.add(id, user_id, amount);

		Thread.sleep(20_000);

		assertEquals(OrderService.get(id), "finished");
	}
}
