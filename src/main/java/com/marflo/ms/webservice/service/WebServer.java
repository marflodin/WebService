package com.marflo.ms.webservice.service;

import com.marflo.ms.webservice.service.enpoints.HomeController;
import com.marflo.ms.webservice.service.enpoints.WebAccountsController;
import com.marflo.ms.webservice.service.enpoints.WebAccountsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class WebServer {

	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-SERVICE";

	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}

	@Bean
	public WebAccountsService accountsService() {
		return new WebAccountsService(ACCOUNTS_SERVICE_URL);
	}

	@Bean
	public WebAccountsController accountsController() {
		return new WebAccountsController(accountsService());
	}

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
}
