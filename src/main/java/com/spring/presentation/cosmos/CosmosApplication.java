package com.spring.presentation.cosmos;

import com.spring.presentation.cosmos.dao.repository.UserReactiveRepository;
import com.spring.presentation.cosmos.dao.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@AllArgsConstructor
@SpringBootApplication
@Slf4j
public class CosmosApplication implements CommandLineRunner {

    private UserRepository repository;

    private UserReactiveRepository reactiveRepository;

    public static void main(String[] args) {
        SpringApplication.run(CosmosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//    	try {
//			repository.findAll().forEach(x -> log.info("{}", x));
//		}catch (Exception ex){
//    		ex.printStackTrace();
//		}finally {
//    		log.info("Ha finalizado la consulta");
//		}
//		reactiveRepository.findAll().doOnNext(x -> log.info("{}", x))
//				.doOnError(e -> e.printStackTrace())
//				.doOnComplete(() -> log.info("Ha finalizado la consulta")).subscribe();
//				reactiveRepository.allNames().doOnNext(x -> log.info("{}", x))
//				.doOnError(e -> e.printStackTrace())
//				.doOnComplete(() -> log.info("Ha finalizado la consulta")).subscribe();

        reactiveRepository.byId("cf0d9caf-ef9f-40ef-a6fc-ee585aac4947").subscribe(x -> log.info("{}", x));

    }
}
