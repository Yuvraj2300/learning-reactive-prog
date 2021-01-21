package com.demo.webflux.websocket.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import com.demo.webflux.model.Student;
import com.demo.webflux.repository.SpringMongoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SampleWebSocketHandler implements WebSocketHandler {

	@Autowired
	SpringMongoRepository repo;

	ObjectMapper objMapper = new ObjectMapper();

	@Override
	public Mono<Void> handle(WebSocketSession session) {
		Flux<Student> allStudentSoruce = repo.findAll();
		System.out.println("***** INCOMING MESSAGES *****");
		session.receive().subscribe(System.out::println);

		System.out.println("***** SENDING STUDENT DATA *****");
		return session.send(allStudentSoruce.map(student -> {
			//System.out.println(writeValueAsString(student));
			return writeValueAsString(student);
		}).map(session::textMessage));
	}

	private String writeValueAsString(Object obj) {
		try {
			return objMapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return	"No data";
	}

}
