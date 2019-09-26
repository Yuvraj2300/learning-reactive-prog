package com.demo.webflux.functional.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.webflux.model.Student;
import com.demo.webflux.repository.SpringMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StudentHandler {

	@Autowired
	private SpringMongoRepository repo;

	public Mono<ServerResponse> getStudent(ServerRequest serverRequest) {
		int rollNo = getInt(serverRequest.pathVariable("rollNo"));
		Mono<Student> student = repo.findByRollNo(rollNo);
		return ServerResponse.ok().body(student, Student.class);
	}

	public Mono<ServerResponse> getAllStudents(ServerRequest request) {
		Flux<Student> students = repo.findAll();
		return ServerResponse.ok().body(students, Student.class);
	}

	private int getInt(String value) {
		int retVal = 0;
		if (value != null && !value.isEmpty()) {
			try {
				retVal = Integer.parseInt(value);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return retVal;
	}
}
