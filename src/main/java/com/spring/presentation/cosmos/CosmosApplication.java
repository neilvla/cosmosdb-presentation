package com.spring.presentation.cosmos;

import com.spring.presentation.cosmos.dao.repository.UserReactiveRepository;
import com.spring.presentation.cosmos.dao.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class CosmosApplication implements CommandLineRunner {

	private UserRepository userRepository;
	private UserReactiveRepository userReactiveRepository;

	public static void main(String[] args) {
		SpringApplication.run(CosmosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.findAll().forEach(System.out::println);
		System.out.println("---------------------------------");
		userReactiveRepository.findAll().subscribe(System.out::println);
	}
}
