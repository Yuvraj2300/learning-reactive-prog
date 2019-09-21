package com.demo.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.webflux.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SpringMongoRepository extends ReactiveMongoRepository<Student, Integer> {
	public Mono<Student> findByRollNo(Integer rollNo);;

	//Multiple Students by Same Name
	public Flux<Student> findByName(String name);
}
