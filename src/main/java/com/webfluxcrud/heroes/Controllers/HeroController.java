package com.webfluxcrud.heroes.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.webfluxcrud.heroes.entity.Heroes;
import com.webfluxcrud.heroes.repository.HeroRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/heroes")

public class HeroController {

	@Autowired
	HeroRepository heroRepository;
	
	@GetMapping
    public Flux<Heroes> getAllHeroes() {
        return heroRepository.findAll();
    }
	
	@PostMapping
    public Mono<Heroes> createHero( @RequestBody Heroes hero) {
        return heroRepository.save(hero);
    }

	@GetMapping("/{id}")
    public Mono<ResponseEntity<Heroes>> getHeroById(@PathVariable(value = "id") int heroId) {
        return heroRepository.findById(heroId)
                .map(savedTweet -> ResponseEntity.ok(savedTweet))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
	
	@Bean
    RouterFunction<ServerResponse> helloRouterFunction() {
		
        RouterFunction<ServerResponse> routerFunction =
                RouterFunctions.route(RequestPredicates.path("/"),
                        serverRequest ->
                                ServerResponse.ok().body(Mono.just("Hello World!"), String.class));

        return routerFunction;
		
	
//				RouterFunction<ServerResponse> userRoutes =
//				   RouterFunctions.nest(RequestPredicates.method(HttpMethod.GET), userRepository.findAll())
//				     .andRoute(RequestPredicates.method(HttpMethod.POST), this::createUser);
//
//				 RouterFunction<ServerResponse> nestedRoute =
//				   RouterFunctions.nest(RequestPredicates.path("/user"),userRoutes);
//		return nestedRoute;
				
//				RouterFunctions.nest(RequestPredicates.path("/rus"),  request -> ok().body(userRepository.findAll()),User.class);

    }

	
}
