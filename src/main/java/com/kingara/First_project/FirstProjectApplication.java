package com.kingara.First_project;

import com.kingara.First_project.services.FileStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner {

	@Resource
	FileStorageService fileStorageService;

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileStorageService.deleteAll();
		fileStorageService.init();
	}
}
