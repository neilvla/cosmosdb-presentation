package com.spring.presentation.cosmos;

import com.spring.presentation.cosmos.dao.repository.UserReactiveRepository;
import com.spring.presentation.cosmos.dao.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
@Slf4j
public class CosmosApplication implements CommandLineRunner {

	private UserRepository userRepository;
	private UserReactiveRepository userReactiveRepository;

	public static void main(String[] args) {
		SpringApplication.run(CosmosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//programacionPorProcedimiento();
		//programacionReactiva();
		userReactiveRepository.allByLastName("Gonzáles").subscribe(System.out::println, throwable -> log.error("Error: {}", throwable.getMessage()));
	}

	private void programacionPorProcedimiento() {
		try {
			userRepository.findAll().forEach(System.out::println);
		}catch (Exception ex) {
			log.error("Error: {}" + ex.getMessage());
		}finally {
			log.info("Proceso finalizado");
		}
	}

	private void programacionReactiva(){
		System.out.println("---------------------------------");
		//userReactiveRepository.findAll().subscribe(System.out::println);
		userReactiveRepository.findAll().doOnNext(System.out::println)
				.doOnError(ex -> log.error("Error: {}" + ex.getMessage()))
				.doOnComplete(() -> log.info("Proceso finalizado")).subscribe();
	}
}
