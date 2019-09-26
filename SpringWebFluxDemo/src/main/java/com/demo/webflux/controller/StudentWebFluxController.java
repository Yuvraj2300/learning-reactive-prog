package com.demo.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webflux.model.Student;
import com.demo.webflux.repository.SpringMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class StudentWebFluxController {

	@Autowired
	SpringMongoRepository repo;

	@GetMapping("/students/{rollNo}")
	public Mono<ResponseEntity<Student>> getStudent(@PathVariable Integer rollNo) {
		Mono<Student> studentMono = repo.findByRollNo(rollNo);

		return studentMono.map(s -> ResponseEntity.ok(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	
	@GetMapping("/students/name/{name}")
	public	Flux<ResponseEntity<Student>> getStudentByName(@PathVariable	String	name){
		Flux<Student>	studentFulx	=	repo.findByName(name);
		
		return studentFulx.map(s -> ResponseEntity.ok(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/students")
	public Flux<?> getAllStudent() {
		Flux<Student> allStudents = repo.findAll();
		
		return	allStudents.map(s->ResponseEntity.ok());
	}
}
