package com.cloud.test;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = { "com.cloud" })
public class CloudTestApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CloudTestApplication.class, args);

	}

}
