package com.pdf.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PdfLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfLoginApplication.class, args);
	}

}
