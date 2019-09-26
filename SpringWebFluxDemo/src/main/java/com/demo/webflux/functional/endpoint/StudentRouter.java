package com.demo.webflux.functional.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class StudentRouter {

	@Autowired
	private StudentHandler handler;

	@Bean
	RouterFunction<ServerResponse> returnStudent() {
		return RouterFunctions.route(RequestPredicates.GET("/api/f/students/{rollNo}"), handler::getStudent);
	}

	@Bean
	RouterFunction<ServerResponse> returnAllStudents() {
		return RouterFunctions.route(RequestPredicates.GET("/api/f/students"), handler::getAllStudents);
	}

}
