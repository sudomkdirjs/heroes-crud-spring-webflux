package com.webfluxcrud.heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

//import com.webfluxcrud.heroes.entity.Heroes;
import com.webfluxcrud.heroes.repository.HeroRepository;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class HeroesApplication {

	@Autowired
	HeroRepository heroRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HeroesApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {

			System.out.println("::::::::::::::::::::::");

			Mono<Void> sss = heroRepository.deleteAll();

			sss.subscribe((e) -> {

			}, Throwable::printStackTrace);

		};

	}
}

