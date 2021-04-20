package com.example.test;

import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest
@RunWith(SpringRunner.class)
class TestApplicationTests {

	private WebTestClient webClient;



	@Before
	public void before (){
		this.webClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
	}

	@Test
	void eventById()  throws Exception {
		this.webClient
				.get()
				.uri("/events/2")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus()
				.isOk();
	}

}
