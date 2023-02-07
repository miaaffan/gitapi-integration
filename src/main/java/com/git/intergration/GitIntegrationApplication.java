package com.git.intergration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GitIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitIntegrationApplication.class, args);
	}

}
