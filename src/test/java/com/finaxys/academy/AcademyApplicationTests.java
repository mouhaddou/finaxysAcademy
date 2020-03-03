package com.finaxys.academy;

import com.finaxys.academy.config.SecurityConfiguration;
import com.jayway.restassured.RestAssured;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = SecurityConfiguration.class)
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)


public class AcademyApplicationTests {

		@Value("${server.port}")
		int port;
	@Test
	public void getDataTest() {
		//get("/api/tdd/responseData").then().assertThat().body("data", equalTo("responseData"));
	}
	@Before
	public void setBaseUri () {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost"; // replace as appropriate
	}
}
